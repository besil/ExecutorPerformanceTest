package performance.akka;

import performance.PerformanceExecutor;
import akka.actor.UntypedActor;

public class PrimeActor extends UntypedActor {
	@Override
	public void onReceive(Object m) throws Exception {
		if( m instanceof MyNumber ) {
			PerformanceExecutor.isPrime( ((MyNumber)m).getLong());
		}
	}
}
