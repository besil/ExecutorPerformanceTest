package main;

import context.ExecutorContext;
import performance.ClassicExecutor;
import performance.ForkJoinExecutor;
import performance.akka.AkkaExecutor;

public class ExecutorPerformanceMain {
	public static void main(String[] args) throws Exception {
		final int nthreads = 4, max=10_000_000;
		ExecutorContext context = new ExecutorContext(nthreads, max);
		
		double fjtime = context.setEngine(new ForkJoinExecutor()).execute();
		double extime = context.setEngine(new ClassicExecutor()).execute();
		double aktime = context.setEngine(new AkkaExecutor()).execute();

		System.out.println("ForkJoin: "+fjtime+" s");
		System.out.println("Executor: "+extime+" s");
		System.out.println("Akka    : "+aktime+" s");
		
	}
}
