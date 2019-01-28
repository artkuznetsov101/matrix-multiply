package com.test;

public class RecursiveMultiplier implements Multiplier {

	static int MIN = 1;

	@Override
	public int[][] multiply(int[][] m1, int[][] m2) throws Exception {

		int m1Rows = m1.length;
		int m1Columns = m1[0].length;

		int m2Rows = m2.length;
		int m2Columns = m2[0].length;

		// The number of columns of the 1st matrix must equal the number of rows of the
		// 2nd matrix.
		if (m1Columns != m2Rows)
			return null;

		// The result will have the same number of rows as the 1st matrix, and the same
		// number of columns as the 2nd matrix.
		int[][] result = new int[m1Rows][m2Columns];

		result = compute(m1, 0, 0, m2, 0, 0, result, 0, 0, m1.length);

		return result;
	}

	public int[][] compute(int[][] m1, int m1Row, int m1Column, int[][] m2, int m2Row, int m2Column, int[][] mr, int mrRow, int mrColumn, int inputSize) {
		if (inputSize == MIN) {
			mr[m1Row][m2Column] += m1[m1Row][m1Column] * m2[m2Row][m2Column];
			return mr;
		} else {
			int size = inputSize / 2;

			this.compute(m1, m1Row, m1Column, m2, m2Row, m2Column, mr, mrRow, mrColumn, size);
			this.compute(m1, m1Row, m1Column + size, m2, m2Row + size, m2Column, mr, mrRow, mrColumn, size);
			this.compute(m1, m1Row, m1Column, m2, m2Row, m2Column + size, mr, mrRow, mrColumn, size);
			this.compute(m1, m1Row, m1Column + size, m2, m2Row + size, m2Column + size, mr, mrRow, mrColumn, size);
			this.compute(m1, m1Row + size, m1Column, m2, m2Row, m2Column, mr, mrRow, mrColumn, size);
			this.compute(m1, m1Row + size, m1Column + size, m2, m2Row + size, m2Column, mr, mrRow, mrColumn, size);
			this.compute(m1, m1Row + size, m1Column, m2, m2Row, m2Column + size, mr, mrRow, mrColumn, size);
			this.compute(m1, m1Row + size, m1Column + size, m2, m2Row + size, m2Column + size, mr, mrRow, mrColumn, size);

			return mr;
		}
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub

	}
}