package main;

import performance.akka.AkkaExecutor;

public class ExecutorPerformanceMain {
	public static void main(String[] args) throws Exception {
//		new ForkJoinExecutor().execute();
//		new ClassicExecutor().execute();
		new AkkaExecutor().execute();
	}
}
