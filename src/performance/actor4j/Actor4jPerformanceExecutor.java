package performance.actor4j;

import java.util.LinkedList;
import java.util.List;

import org.besil.actor.Actor;

import performance.PerformanceExecutor;

public class Actor4jPerformanceExecutor extends PerformanceExecutor {
	private List<Actor> actors;
	
	@Override
	public void init(int nthreads) {
		this.actors = new LinkedList<>();
		for(int i=0; i<nthreads; i++)
			actors.add(new PrimeActor());
		
		actors.forEach(actor -> actor.start());
	}

	@Override
	public void execute(int max) throws Exception {
		int nthreads = this.actors.size();

		for(int i=0; i<max; i++) {
			actors.get(i % nthreads).send(new LongMessage(i));
		}
	}

	@Override
	public void exit() {
		actors.forEach(actor -> actor.shutdown());
	}

}
