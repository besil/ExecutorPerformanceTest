package main;

import performance.ClassicExecutor;
import performance.ForkJoinExecutor;
import performance.akka.AkkaExecutor;

public class ExecutorPerformanceMain {
	public static void main(String[] args) throws Exception {
		double fjtime = new ForkJoinExecutor().execute();
		double extime = new ClassicExecutor().execute();
		double aktime = new AkkaExecutor().execute();
		
		System.out.println("ForkJoin: "+fjtime+" s");
		System.out.println("Executor: "+extime+" s");
		System.out.println("Akka    : "+aktime+" s");
	}
}
