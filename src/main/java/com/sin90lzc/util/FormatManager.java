package com.sin90lzc.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.sin90lzc.util.enums.DateFormatPattern;

/**
 * 格式化工具类
 * 
 * @author tim
 * 
 */
public final class FormatManager {

	private static final String HH_MI = "HH:mm";
	private static final String YYYY_MM_DD = "yyyy-MM-dd";
	private static final String YYYY_MM_DD_HH_MI = "yyyy-MM-dd HH:mm";
	private static final String YYYY_MM_DD_HH_MI_SS = "yyyy-MM-dd HH:mm:ss";
	private static final String YYYYMMDD = "yyyyMMdd";
	private static final String HH_MI_SS = "HH:mm:ss";
	private static final String YYYYMMDDHHMISS = "yyyyMMddHHmmss";
	private static final String YY_MM_DD = "yy-MM-dd";

	private static DateFormat HH_MI_FORMAT = null;
	private static DateFormat YYYY_MM_DD_FORMAT = null;
	private static DateFormat YYYY_MM_DD_HH_MI_FORMAT = null;
	private static DateFormat YYYY_MM_DD_HH_MI_SS_FORMAT = null;
	private static DateFormat YYYYMMDD_FORMAT = null;
	private static DateFormat HH_MI_SS_FORMAT = null;
	private static DateFormat YYYYMMDDHHMISS_FORMAT = null;
	private static DateFormat YY_MM_DD_FORMAT = null;

	private static Map<String, DecimalFormat> decimalFormaterMap = Collections
			.synchronizedMap(new HashMap<String, DecimalFormat>());

	/**
	 * 按pattern的模式格式化date
	 * 
	 * @param pattern
	 * @param date
	 * @return
	 */
	public final static String format(DateFormatPattern pattern, Date date) {
		DateFormat formater = getDateFormat(pattern);
		return formater.format(date);
	}

	public final static String format(DateFormatPattern pattern, Calendar cal) {
		return format(pattern, cal.getTime());
	}

	/**
	 * 格式化数字
	 * @param pattern
	 * @param num
	 * @return
	 */
	public final static String formatDecimal(String pattern, double num) {
		return getDecimalFormat(pattern).format(num);
	}

	public final static DecimalFormat getDecimalFormat(String pattern) {
		if (decimalFormaterMap.containsKey(pattern)) {
			return decimalFormaterMap.get(pattern);
		}
		DecimalFormat formater = new DecimalFormat(pattern);
		decimalFormaterMap.put(pattern, formater);
		return formater;
	}

	private static DateFormat getDateFormat(DateFormatPattern pattern) {
		switch (pattern) {
		case HH_MI:
			if (HH_MI_FORMAT != null) {
				return HH_MI_FORMAT;
			} else {
				return new SimpleDateFormat(HH_MI);
			}
		case YYYY_MM_DD:
			if (YYYY_MM_DD_FORMAT != null)
				return YYYY_MM_DD_FORMAT;
			else
				return new SimpleDateFormat(YYYY_MM_DD);
		case YYYY_MM_DD_HH_MI:
			if (YYYY_MM_DD_HH_MI_FORMAT != null)
				return YYYY_MM_DD_HH_MI_FORMAT;
			else
				return new SimpleDateFormat(YYYY_MM_DD_HH_MI);
		case YYYY_MM_DD_HH_MI_SS:
			if (YYYY_MM_DD_HH_MI_SS_FORMAT != null)
				return YYYY_MM_DD_HH_MI_SS_FORMAT;
			else
				return new SimpleDateFormat(YYYY_MM_DD_HH_MI_SS);
		case YYYYMMDD:
			if (YYYYMMDD_FORMAT != null)
				return YYYYMMDD_FORMAT;
			else
				return new SimpleDateFormat(YYYYMMDD);
		case HH_MI_SS:
			if (HH_MI_SS_FORMAT != null)
				return HH_MI_SS_FORMAT;
			else
				return new SimpleDateFormat(HH_MI_SS);
		case YYYYMMDDHHMISS:
			if (YYYYMMDDHHMISS_FORMAT != null)
				return YYYYMMDDHHMISS_FORMAT;
			else
				return new SimpleDateFormat(YYYYMMDDHHMISS);
		case YY_MM_DD:
			if (YY_MM_DD_FORMAT != null)
				return YY_MM_DD_FORMAT;
			else
				return new SimpleDateFormat(YY_MM_DD);
		}
		return null;
	}
}
