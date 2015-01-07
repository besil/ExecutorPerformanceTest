package performance.akka;

import performance.PerformanceExecutor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class AkkaExecutor extends PerformanceExecutor {
	@Override
	public void doWork(int max) throws Exception {
		ActorSystem system = ActorSystem.create("PrimeCalculator");
		ActorRef greeter = system.actorOf(Props.create(PrimeActor.class));
		greeter.tell(new MyNumber(5), ActorRef.noSender());
		system.shutdown();
	}
}
