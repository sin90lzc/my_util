package com.sin90lzc.util.str;

import com.sin90lzc.util.enu.Alignment;

/**
 * 字符串的工具类
 * 
 * @author tim
 * 
 */
public class StringUtil {
	public static final String EMPTY = "";

	public static final char SPACE_CHAR = ' ';

	/**
	 * 在指定的字符串长度(len)内，使字符串srcString向左，居中，或向右对齐，其余空位用append补齐
	 * 
	 * @param align
	 *            指定向左，向右或居中对齐
	 * @param len
	 *            返回字符串的长度，若srcString超出len的长度，则直接返回srcString
	 * @param srcString
	 *            要进行对齐的字符串
	 * @param append
	 *            补位字符
	 * @return
	 */
	public static final String alignTo(Alignment align, int len,
			String srcString, char append) {
		if (srcString == null) {
			srcString = EMPTY;
		}
		if (srcString.length() >= len) {
			return srcString;
		}
		int appendNum = len - srcString.length();
		StringBuffer ret = new StringBuffer();
		switch (align) {

		case RIGHT_ALIGN:
			for (int i = 0; i < appendNum; i++) {
				ret.append(append);
			}
			ret.append(srcString);
			break;
		case CENTRAL_ALIGN:
			for (int i = 0; i < appendNum / 2; i++) {
				ret.append(append);
			}
			ret.append(srcString);
			for (int i = 0; i < appendNum / 2; i++) {
				ret.append(append);
			}
			if (ret.length() < len) {
				ret.append(append);
			}
			break;
		default:
		case LEFT_ALIGN:
			ret.append(srcString);
			for (int i = 0; i < appendNum; i++) {
				ret.append(append);
			}
			break;
		}
		return ret.toString();
	}

	/**
	 * 在指定的字符串长度(len)内，使字符串srcString向左对齐，其余空位用append补齐
	 * 
	 * @param len
	 *            返回字符串的长度，若srcString超出len的长度，则直接返回srcString
	 * @param srcString
	 *            要进行对齐的字符串
	 * @param append
	 *            补位字符
	 * @return
	 */
	public static final String alignToLeft(int len, String srcString,
			char append) {
		return alignTo(Alignment.LEFT_ALIGN, len, srcString, append);
	}

	/**
	 * 在指定的字符串长度(len)内，使字符串srcString向右对齐，其余空位用append补齐
	 * 
	 * @param len
	 *            返回字符串的长度，若srcString超出len的长度，则直接返回srcString
	 * @param srcString
	 *            要进行对齐的字符串
	 * @param append
	 *            补位字符
	 * @return
	 */
	public static final String alignToRight(int len, String srcString,
			char append) {
		return alignTo(Alignment.RIGHT_ALIGN, len, srcString, append);
	}

	/**
	 * 在指定的字符串长度(len)内，使字符串srcString居中对齐，其余空位用append补齐
	 * 
	 * @param len
	 *            返回字符串的长度，若srcString超出len的长度，则直接返回srcString
	 * @param srcString
	 *            要进行对齐的字符串
	 * @param append
	 *            补位字符
	 * @return
	 */
	public static final String alignToCentral(int len, String srcString,
			char append) {
		return alignTo(Alignment.CENTRAL_ALIGN, len, srcString, append);
	}

	/**
	 * 在指定的字符串长度(len)内，使字符串srcString向左对齐，其余空位用空格补齐
	 * 
	 * @param len
	 *            返回字符串的长度，若srcString超出len的长度，则直接返回srcString
	 * @param srcString
	 *            要进行对齐的字符串
	 * @param append
	 *            补位字符
	 * @return
	 */
	public static final String alignToLeft(int len, String srcString) {

		return alignToLeft(len, srcString, SPACE_CHAR);
	}

	/**
	 * 在指定的字符串长度(len)内，使字符串srcString向右对齐，其余空位用空格补齐
	 * 
	 * @param len
	 *            返回字符串的长度，若srcString超出len的长度，则直接返回srcString
	 * @param srcString
	 *            要进行对齐的字符串
	 * @param append
	 *            补位字符
	 * @return
	 */
	public static final String alignToRight(int len, String srcString) {
		return alignToRight(len, srcString, SPACE_CHAR);
	}

	/**
	 * 在指定的字符串长度(len)内，使字符串srcString居中对齐，其余空位用空格补齐
	 * 
	 * @param len
	 *            返回字符串的长度，若srcString超出len的长度，则直接返回srcString
	 * @param srcString
	 *            要进行对齐的字符串
	 * @param append
	 *            补位字符
	 * @return
	 */
	public static final String alignToCentral(int len, String srcString) {
		return alignToCentral(len, srcString, SPACE_CHAR);
	}

}
