package com.test;

public class MultiplierFactory {
	static public Multiplier getSimpleLoopMultiplier() {
		return new SimpleLoopMultiplier();
	}

	static public Multiplier getWorkStealingMultiplier() {
		return new WorkStealingMultiplier();
	}

	static public Multiplier getWorkStealingByRowMultiplier() {
		return new WorkStealingByRowMultiplier();
	}

	static public Multiplier getStreamMultiplier() {
		return new StreamMultiplier();
	}

	static public Multiplier getRecursiveMultiplier() {
		return new RecursiveMultiplier();
	}
}
