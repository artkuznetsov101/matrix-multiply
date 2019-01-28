package com.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WorkStealingTest {

	Multiplier multiplier;
	int[][] m1, m2, mv;

	@Before
	public void setUpBefore() throws Exception {
		multiplier = MultiplierFactory.getWorkStealingMultiplier();
		m1 = MatrixHelper.createMatrix1(Multiplier.matrixSize);
		m2 = MatrixHelper.createMatrix2(Multiplier.matrixSize);
		mv = MatrixHelper.createMultipliedMatrix(Multiplier.matrixSize);
	}

	@Test
	public void testMatrixMultiply() throws Exception {
		if (Multiplier.matrixSize <= Multiplier.debugMatrixSize) {
			System.out.println("matrix 1:");
			System.out.println(MatrixHelper.toString(m1));

			System.out.println("matrix 2:");
			System.out.println(MatrixHelper.toString(m2));

			int[][] result = multiplier.multiply(m1, m2);

			System.out.println("result matrix:");
			System.out.println(MatrixHelper.toString(result));

			System.out.println("valid ? " + MatrixHelper.isEqual(result, mv));
		} else
			multiplier.multiply(m1, m2);
	}

	@After
	public void tearDownAfter() throws Exception {
		multiplier.close();
	}
}
