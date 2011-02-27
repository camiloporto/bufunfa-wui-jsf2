package br.com.bufunfa.finance.util;

import java.util.Calendar;
import java.util.Date;

import junit.framework.Assert;

public class TestUtils {
	
	public static void assertDateEquals(Date expected, Date actual) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(expected);
		
		Calendar c2 = Calendar.getInstance();
		c2.setTime(actual);
		
		Assert.assertEquals(c1.get(Calendar.DAY_OF_MONTH), c2.get(Calendar.DAY_OF_MONTH));
		Assert.assertEquals(c1.get(Calendar.MONTH), c2.get(Calendar.MONTH));
		Assert.assertEquals(c1.get(Calendar.YEAR), c2.get(Calendar.YEAR));
		
	}

}
