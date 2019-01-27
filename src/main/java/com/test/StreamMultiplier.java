package com.test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamMultiplier implements Multiplier {

	@Override
	public int[][] multiply(int[][] m1, int[][] m2) throws Exception {
		int m1Columns = m1[0].length;
		int m2Rows = m2.length;

		//  The number of columns of the 1st matrix must equal the number of rows of the 2nd matrix.
		if (m1Columns != m2Rows)
			return null;

		return Arrays.stream(m1).parallel().map(row -> IntStream.range(0, m2[0].length).map(i -> IntStream.range(0, m2.length).map(j -> row[j] * m2[j][i]).sum()).toArray()).toArray(int[][]::new);
	}

	@Override
	public void close() throws Exception {
		
	}
}
