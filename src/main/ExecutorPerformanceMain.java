package main;

import context.ExecutorContext;
import performance.ClassicExecutor;
import performance.ForkJoinExecutor;
import performance.actor4j.Actor4jPerformanceExecutor;
import performance.akka.AkkaExecutor;

public class ExecutorPerformanceMain {
	public static void main(String[] args) throws Exception {
		final int nthreads = 4, max=10_000_000;
		ExecutorContext context = new ExecutorContext(nthreads, max);
		
		double mytime = context.setEngine(new Actor4jPerformanceExecutor()).execute();
		System.out.println("Actor4j : "+mytime+" s");
		double aktime = context.setEngine(new AkkaExecutor()).execute();
		System.out.println("Akka    : "+aktime+" s");
		
		double fjtime = context.setEngine(new ForkJoinExecutor()).execute();
		System.out.println("ForkJoin: "+fjtime+" s");
		double extime = context.setEngine(new ClassicExecutor()).execute();
		System.out.println("Executor: "+extime+" s");
		
	}
}
