package context;

import java.time.Clock;

import performance.PerformanceExecutor;

public class ExecutorContext {
	protected final int nthreads, max;
	protected PerformanceExecutor executor;
	protected Clock clock;
	
	public ExecutorContext(int nthreads, int max) {
		this.nthreads 	= nthreads;
		this.max 		= max;
		this.clock 		= Clock.systemDefaultZone();
		this.executor 	= null;
	}

	public ExecutorContext setEngine(PerformanceExecutor executor) {
		this.executor = executor;
		return this;
	}

	/**
	 * Returns the computation time of the current Performance Executor
	 * @return
	 * @throws Exception 
	 */
	public double execute() throws Exception {
		this.executor.init(nthreads);

		long start 	= clock.millis();
		executor.execute(max);
		long end 	= clock.millis();
		executor.exit();
		return (end - start) / 1000.0;
	}
	
}
