package utils.thread;

public class SubThread extends Thread {

	private final int i;

	public SubThread(int i) {
		this.i = i;
	}

	@Override
	public void run() {
		System.out.println(i);
	}
}
