package performance.actor4j;

import org.besil.actor.impl.LocalActor;

import performance.PerformanceExecutor;

public class PrimeActor extends LocalActor {
	public void receive(LongMessage intMex) {
		PerformanceExecutor.isPrime(intMex.n);
	}
}