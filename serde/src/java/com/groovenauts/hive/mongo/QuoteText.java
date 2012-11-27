package com.groovenauts.hive.mongo;

import org.apache.hadoop.io.Text;

public class QuoteText {

	// private static final Log LOG = LogFactory.getLog(SqlTimestamp.class);

	private static final byte SINGLE_QUOTE = "'".getBytes()[0];
	private static final byte DOUBLE_QUOTE = "\"".getBytes()[0];

	public static void setTo(Text data, byte[] d, int start, int length) {
		if (length < 3) {
			// if the data is not escaped, simply copy the data.
			data.set(d, start, length);
		} else {
			final byte first = d[start];
			final byte last = d[start + length - 1];
			if ((first == last) && ((first == SINGLE_QUOTE) || (first == DOUBLE_QUOTE))) {
				// if the data is not escaped, simply copy the data.
				data.set(d, start + 1, length - 2);
			} else {
				// if the data is not escaped, simply copy the data.
				data.set(d, start, length);
			}
		}
	}
}
