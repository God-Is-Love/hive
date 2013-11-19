package com.groovenauts.hive.mongo;

import java.sql.Timestamp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SqlTimestamp {

  public static final Pattern SPACES = Pattern.compile("^\\s*$");
  public static final Pattern DATE_TIME_ISO8601_T = Pattern.compile("T");
	public static final Pattern DATE_TIME_ISO8601_Z = Pattern.compile("Z$");

    // private static final Log LOG = LogFactory.getLog(SqlTimestamp.class);

	public static Timestamp valueOf(String s){
    if (s == null) {
      return null;
    }
    final Matcher ms = SPACES.matcher(s);
    if (ms.find()) {
      return null;
    }
		final Matcher mt = DATE_TIME_ISO8601_T.matcher(s);
		s = mt.replaceFirst(" ");
		final Matcher mz = DATE_TIME_ISO8601_Z.matcher(s);
		s = mz.replaceFirst("");
		try{
      return Timestamp.valueOf(s);
		} catch(IllegalArgumentException e) {
		  throw new IllegalArgumentException(e.getMessage() + " but value is " + s);
		}
	}

}
