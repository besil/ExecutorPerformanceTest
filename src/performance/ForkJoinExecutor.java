package performance;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class ForkJoinExecutor extends PerformanceExecutor {
	protected ForkJoinPool forkJoinPool;

	@Override
	public void init(int nthreads) {
		this.forkJoinPool = new ForkJoinPool(nthreads);
	}

	@Override
	public void execute(int max) throws Exception {
		this.forkJoinPool.submit(() -> 
			PerformanceExecutor.range(1, max)
			.parallel()
			.filter(PerformanceExecutor::isPrime)
			.boxed()
			.collect(Collectors.toList())
		).get();
	}
	
	@Override
	public void exit() {
		this.forkJoinPool.shutdown();
	}

}
