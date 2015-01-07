package performance;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClassicExecutor extends PerformanceExecutor {
	protected ExecutorService executor;
	
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
	public void init(int nthreads) {
		this.executor = Executors.newFixedThreadPool(nthreads);
	}
	
	@Override
	public void execute(int max) throws Exception {
		for( int i=0; i<max; i++ ) {
			this.executor.submit(new Worker(i));
		}
	}
	
	@Override
	public void exit() {
		this.executor.shutdown();		
	}

}
