package com.test;

public interface Multiplier extends AutoCloseable {

	int matrixSize = 1024;
	int debugMatrixSize = 16;

	int[][] multiply(int[][] m1, int[][] m2) throws Exception;
}
