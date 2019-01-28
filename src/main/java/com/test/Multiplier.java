package com.test;

public interface Multiplier extends AutoCloseable {

	int size = 1000;

	int[][] multiply(int[][] m1, int[][] m2) throws Exception;
}
