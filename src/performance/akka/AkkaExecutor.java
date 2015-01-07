package performance.akka;

import java.util.ArrayList;
import java.util.List;

import performance.PerformanceExecutor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class AkkaExecutor extends PerformanceExecutor {
	@Override
	public void doWork(int max) throws Exception {
		ActorSystem system = ActorSystem.create("PrimeCalculator");
		List<ActorRef> actors = new ArrayList<ActorRef>(nthreads);
		for( int n=0; n<nthreads; n++ ) {
			actors.add(system.actorOf(Props.create(PrimeActor.class)));
		}
		
//		ActorRef p = system.actorOf(Props.create(PrimeActor.class));
		for(int i=0; i<max; i++) {
			actors.get(i % nthreads).tell(new MyNumber(i), ActorRef.noSender());
		}
		system.shutdown();
	}
}
