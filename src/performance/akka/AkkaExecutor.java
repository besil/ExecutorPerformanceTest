package performance.akka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import performance.PerformanceExecutor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class AkkaExecutor extends PerformanceExecutor {
	protected ActorSystem system;
	protected List<ActorRef> actors;

	@Override
	public void init(int nthreads) {
		// Get configuration (no dead letters log)
		Map<String, Object> configuration = new HashMap<>();
		configuration.put("akka.log-dead-letters-during-shutdown", "off");
		Config config = ConfigFactory.parseMap(configuration);
		
		this.system = ActorSystem.create("PrimeCalculator", config);
		int totActors = nthreads;
		
		this.actors = new ArrayList<ActorRef>(totActors);
		for( int n=0; n<totActors; n++ ) {
			actors.add(system.actorOf(Props.create(PrimeActor.class)));
		}
	}

	@Override
	public void execute(int max) throws Exception {
		int nthreads = this.actors.size();

		for(int i=0; i<max; i++) {
			actors.get(i % nthreads).tell(new MyNumber(i), ActorRef.noSender());
		}
	}

	@Override
	public void exit() {
		system.shutdown();
	}
}
