package main;

import performance.ClassicExecutor;

public class ExecutorPerformanceMain {
	public static void main(String[] args) throws Exception {
//		new ForkJoinExecutor().execute();
		new ClassicExecutor().execute();
	}
}
