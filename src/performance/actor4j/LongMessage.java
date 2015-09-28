package performance.actor4j;

import messages.ActorMessage;

public class LongMessage implements ActorMessage {
	public long n;
	public LongMessage(int n) {
		this.n = n;
	}
}