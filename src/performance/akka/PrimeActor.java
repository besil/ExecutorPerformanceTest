package performance.akka;

import akka.actor.UntypedActor;

public class PrimeActor extends UntypedActor {
	@Override
	public void onReceive(Object m) throws Exception {
		if( m instanceof MyNumber ) {
			System.out.println(m);
		}
	}
}
