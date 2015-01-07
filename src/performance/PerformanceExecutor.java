package performance;

import java.util.stream.IntStream;

public abstract class PerformanceExecutor {
	public abstract void init(int nthreads);
	
	public abstract void execute(int max) throws Exception;
	
	public abstract void exit();
	
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
