package com.test;

import java.util.concurrent.Callable;

public class WorkThread implements Callable<Work> {

	Work work;

	public WorkThread(Work work) {
		this.work = work;
	}

	@Override
	public Work call() throws Exception {
		for (int i = 0; i < work.row.length; i++) {
			work.result += work.row[i] * work.column[i];
		}
		return work;
	}
}
