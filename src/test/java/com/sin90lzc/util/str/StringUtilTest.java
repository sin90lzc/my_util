package com.sin90lzc.util.str;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

	private static final String SRC_STR = "Hi,Tim!";
	private static final String ALIGN_TO_LEFT_STR = "Hi,Tim!        ";
	private static final String ALIGN_TO_RIGHT_STR = "        Hi,Tim!";
	private static final String ALIGN_TO_CENTRAL_STR = "    Hi,Tim!    ";
	private static final String TOO_LONG_STR = "Hi,Tim!How ar you?";
	private static final int ALIGN_LENGTH = 15;

	@Test
	public void alignToTest() {
		alignToLeft();
		alignToRight();
		alignToCentral();
	}

	private void alignToLeft() {
		String t1 = StringUtil.alignToLeft(ALIGN_LENGTH, SRC_STR);
		Assert.assertEquals(ALIGN_LENGTH, t1.length());
		Assert.assertEquals(ALIGN_TO_LEFT_STR, t1);
		String t2 = StringUtil.alignToLeft(ALIGN_LENGTH, SRC_STR, '*');
		Assert.assertEquals(ALIGN_LENGTH, t2.length());
		Assert.assertEquals("Hi,Tim!********", t2);
		String t3 = StringUtil.alignToLeft(ALIGN_LENGTH, TOO_LONG_STR);
		Assert.assertEquals(TOO_LONG_STR, t3);

	}

	private void alignToRight() {
		String t1 = StringUtil.alignToRight(ALIGN_LENGTH, SRC_STR);
		Assert.assertEquals(ALIGN_LENGTH, t1.length());
		Assert.assertEquals(ALIGN_TO_RIGHT_STR, t1);
		String t2 = StringUtil.alignToRight(ALIGN_LENGTH, SRC_STR, '*');
		Assert.assertEquals(ALIGN_LENGTH, t2.length());
		Assert.assertEquals("********Hi,Tim!", t2);
		String t3 = StringUtil.alignToRight(ALIGN_LENGTH, TOO_LONG_STR);
		Assert.assertEquals(TOO_LONG_STR, t3);
	}

	private void alignToCentral() {
		String t1 = StringUtil.alignToCentral(ALIGN_LENGTH, SRC_STR);
		Assert.assertEquals(ALIGN_LENGTH, t1.length());
		Assert.assertEquals(ALIGN_TO_CENTRAL_STR, t1);
		String t2 = StringUtil.alignToCentral(ALIGN_LENGTH, SRC_STR, '*');
		Assert.assertEquals(ALIGN_LENGTH, t2.length());
		Assert.assertEquals("****Hi,Tim!****", t2);
		String t3 = StringUtil.alignToCentral(ALIGN_LENGTH, TOO_LONG_STR);
		Assert.assertEquals(TOO_LONG_STR, t3);
	}
}
