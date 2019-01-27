package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WorkStealingByRowMultiplier implements Multiplier, AutoCloseable {

	ExecutorService pool = Executors.newWorkStealingPool();
	List<Callable<Work>> multiplierThreads = new ArrayList<>();

	@Override
	public int[][] multiply(int[][] m1, int[][] m2) throws InterruptedException, ExecutionException {

		int m1Rows = m1.length;
		int m1Columns = m1[0].length;

		int m2Rows = m2.length;
		int m2Columns = m2[0].length;

		//  The number of columns of the 1st matrix must equal the number of rows of the 2nd matrix.
		if (m1Columns != m2Rows)
			return null;

		// The result will have the same number of rows as the 1st matrix, and the same number of columns as the 2nd matrix.
		int[][] result = new int[m1Rows][m2Columns];

		int count = 0;
		List<Future<Work>> futureResult;
		for (int i = 0; i < m1Rows; i++) {
			for (int j = 0; j < m2Columns; j++) {
				multiplierThreads.add(new WorkThread(new Work(m1[i], m2[j])));
			}

			futureResult = pool.invokeAll(multiplierThreads);

			for (Future<Work> future : futureResult) {
				result[i][count++] = future.get().result;
			}
			multiplierThreads.clear();
			count = 0;
		}

		return result;
	}

	@Override
	public void close() throws Exception {
		pool.shutdown();
	}
}
