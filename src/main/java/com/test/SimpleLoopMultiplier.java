package com.test;

public class SimpleLoopMultiplier implements Multiplier {

	@Override
	public int[][] multiply(int[][] m1, int[][] m2) {

		int m1Rows = m1.length;
		int m1Columns = m1[0].length;

		int m2Rows = m2.length;
		int m2Columns = m2[0].length;

		//  The number of columns of the 1st matrix must equal the number of rows of the 2nd matrix.
		if (m1Columns != m2Rows)
			return null;

		// The result will have the same number of rows as the 1st matrix, and the same number of columns as the 2nd matrix.
		int[][] result = new int[m1Rows][m2Columns];

		for (int i = 0; i < m1Rows; i++) {
			for (int j = 0; j < m2Columns; j++) {
				for (int k = 0; k < m1Columns; k++) {
					result[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return result;
	}

	@Override
	public void close() throws Exception {
		
	}
}
