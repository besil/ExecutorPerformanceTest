package performance;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClassicExecutor extends PerformanceExecutor {
	class Worker implements Runnable {
		final int p;
		public Worker(int p) {
			this.p = p;
		}

		@Override
		public void run() {
			isPrime(p);
		}
	}
	
	@Override
	public void doWork(int max) throws Exception {
		ExecutorService executor = Executors.newFixedThreadPool(nthreads);
		
		for( int i=0; i<max; i++ ) {
			executor.submit(new Worker(i));
		}
		
		executor.shutdown();
	}

}
