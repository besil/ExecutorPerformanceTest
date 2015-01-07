package performance;

import java.time.Clock;
import java.util.stream.IntStream;

public abstract class PerformanceExecutor {
	protected final int nthreads, max;
	
	public PerformanceExecutor() {
		this(Runtime.getRuntime().availableProcessors(), 10_000_000);
	}
	
	public PerformanceExecutor(int nthreads, int max) {
		this.nthreads 	= nthreads;
		this.max 		= max;
	}
	
	public void execute() throws Exception {
		Clock clock = Clock.systemDefaultZone();
		long start = clock.millis();
		
		this.doWork(max);
		
		long end = clock.millis();
		System.out.println("Total time: "+((end - start)/1000.0) +" s");
	}
	
	public abstract void doWork(int max) throws Exception;
	
	public static boolean isPrime(long n) {
		return n > 1 && rangeClosed(2, (int) Math.sqrt(n)).noneMatch(divisor -> n % divisor == 0);
	}
	
	public static IntStream range(int start, int end) {
		return IntStream.range(start, end);
	}
	
	public static IntStream rangeClosed(int start, int end) {
		return IntStream.rangeClosed(start, end);
	}
}
