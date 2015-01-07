package performance.akka;

import java.io.Serializable;

public class MyNumber implements Serializable {
	private static final long serialVersionUID = 1L;
	private final int n;
	public MyNumber(int n) {
		this.n = n;
	}
	@Override
	public String toString() {
		return n+"";
	}
}