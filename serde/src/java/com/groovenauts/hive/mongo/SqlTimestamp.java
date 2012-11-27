package com.groovenauts.hive.mongo;

import java.sql.Timestamp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SqlTimestamp {
	
	public static final Pattern DATE_TIME_ISO8601_T = Pattern.compile("T");
	public static final Pattern DATE_TIME_ISO8601_Z = Pattern.compile("Z$");

    private static final Log LOG = LogFactory.getLog(SqlTimestamp.class);

	public static Timestamp valueOf(String s){
		LOG.warn("SqlTimestamp is working!!");
		final Matcher mt = DATE_TIME_ISO8601_T.matcher(s);
		s = mt.replaceFirst(" ");
		final Matcher mz = DATE_TIME_ISO8601_Z.matcher(s);
		s = mz.replaceFirst("");
		return Timestamp.valueOf(s);
	}

}
