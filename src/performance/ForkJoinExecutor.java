package performance;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class ForkJoinExecutor extends PerformanceExecutor {
	
	public ForkJoinExecutor() {
		super();
	}
	
	public ForkJoinExecutor(int nthreads, int max) {
		super(nthreads, max);
	}

	@Override
	public void doWork(final int max) throws Exception {
		ForkJoinPool forkJoinPool = new ForkJoinPool(this.nthreads);
		forkJoinPool.submit(() -> 
			PerformanceExecutor.range(1, max)
			.parallel()
			.filter(PerformanceExecutor::isPrime)
			.boxed()
			.collect(Collectors.toList())
		).get();		
	}
}
