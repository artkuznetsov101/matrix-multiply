package com.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SimpleLoopTest {

	Multiplier multiplier;
	int[][] m1;
	int[][] m2;
	
	@Before
	public void setUpBefore() throws Exception {
		multiplier = MultiplierFactory.getSimpleLoopMultiplier();	
		m1 = MatrixHelper.createMatrix1(Multiplier.size);
		m2 = MatrixHelper.createMatrix2(Multiplier.size);	
	}
	
	@Test
	public void testGetTimestampWithTimezone() throws Exception {
		multiplier.multiply(m1, m2);
	}
	
	@After
	public void tearDownAfter() throws Exception {
	
	}
}

