package com.sin90lzc.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.sin90lzc.util.enums.DateFormatPattern;

public class FormatManagerTest {

	private static final String DATE_STRING = "20140228124050";

	@Test
	public void testFormatDate() throws Exception {
		DateFormat formater = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = formater.parse(DATE_STRING);
		Assert.assertEquals("12:40",
				FormatManager.format(DateFormatPattern.HH_MI, date));
		Assert.assertEquals("12:40:50",
				FormatManager.format(DateFormatPattern.HH_MI_SS, date));
		Assert.assertEquals("14-02-28",
				FormatManager.format(DateFormatPattern.YY_MM_DD, date));
		Assert.assertEquals("2014-02-28",
				FormatManager.format(DateFormatPattern.YYYY_MM_DD, date));
		Assert.assertEquals("2014-02-28 12:40",
				FormatManager.format(DateFormatPattern.YYYY_MM_DD_HH_MI, date));
		Assert.assertEquals("2014-02-28 12:40:50", FormatManager.format(
				DateFormatPattern.YYYY_MM_DD_HH_MI_SS, date));
		Assert.assertEquals("20140228",
				FormatManager.format(DateFormatPattern.YYYYMMDD, date));
		Assert.assertEquals("20140228124050",
				FormatManager.format(DateFormatPattern.YYYYMMDDHHMISS, date));

	}
}
