package com.sin90lzc.util.str;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;

public class ReplacementUtil {

	private final static String VAR_PATTERN_STR = "\\$\\{(.*?)\\}";
	private final static Pattern VAR_PATTERN = Pattern.compile(VAR_PATTERN_STR);

	private static final JexlEngine ENGINE = new JexlEngine();

	static {
		//ENGINE.setCache(512);
		//ENGINE.setLenient(false);
		//ENGINE.setSilent(false);
	}

	/**
	 * 大文本变量替换
	 * 
	 * @param src 大文本（包含变量形式${var.x})
	 * @param vars 用于替换的变量
	 * @return
	 */
	public static final String replace(String src, Map<String,Object> vars) {
		MapContext context = new MapContext(vars);
		Matcher matcher = VAR_PATTERN.matcher(src);
		StringBuffer ret = new StringBuffer();
		while (matcher.find()) {
			String key = matcher.group(1).trim();
			Expression ex = ENGINE.createExpression(key);
			String value = null;
			value = ex.evaluate(context).toString();
			matcher.appendReplacement(ret, value);
		}
		matcher.appendTail(ret);
		return ret.toString();
	}
}
