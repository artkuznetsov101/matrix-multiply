package com.test;

public class MatrixHelper {

	static int SEED = 2;

	public static void main(String[] args) throws Exception {

		int matrixSize = 4;
		
		int[][] m1 = createMatrix1(matrixSize);
		System.out.println("matrix 1");
		System.out.println(toString(m1));

		int[][] m2 = createMatrix2(matrixSize);
		System.out.println("matrix 2");
		System.out.println(toString(m2));

		int[][] mValid = createMultipliedMatrix(matrixSize);
		System.out.println("multiplied matrix");
		System.out.println(toString(mValid));

		Multiplier multiplier = MultiplierFactory.getWorkStealingByRowMultiplier();

		int[][] result = multiplier.multiply(m1, m2);
		System.out.println("result matrix");
		System.out.println(toString(result));

		System.out.println("valid matrix");
		System.out.println(toString(mValid));

		System.out.println("valid ? " + isEqual(result, mValid));
	}

	public static int[][] createMatrix1(int size) {
		int[][] matrix = new int[size][size];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = j + 1;
			}
		}
		return matrix;
	}

	public static int[][] createMatrix2(int size) {
		int[][] matrix = new int[size][size];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = SEED;
			}
		}
		return matrix;
	}

	public static int[][] createMultipliedMatrix(int size) {
		int[][] matrix = new int[size][size];
		int value = 0;
		for (int i = 0; i < size; i++) {
			value += (i + 1) * SEED;
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = value;
			}
		}
		return matrix;
	}

	public static String toString(int[][] matrix) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				result.append(String.format("%d ", matrix[i][j]));
			}
			result.append("\n");
		}
		return result.toString();
	}

	public static boolean isEqual(int[][] m1, int[][] m2) {

		if (m1.length != m2.length || m1[0].length != m2[0].length)
			return false;

		int i, j;
		for (i = 0; i < m1.length; i++)
			for (j = 0; j < m1.length; j++)
				if (m1[i][j] != m2[i][j])
					return false;
		return true;
	}
}
