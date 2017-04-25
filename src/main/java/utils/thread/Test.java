package utils.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	public static void main(String args[]) throws InterruptedException {
		System.out.println(139/50);
		System.out.println(149/50);
		
		
		
		long start = System.currentTimeMillis();
		ExecutorService exe = Executors.newFixedThreadPool(50);
		for (int i = 1; i <= 50; i++) {
			exe.execute(new SubThread(i));
		}
		exe.shutdown();
		while (true) {
			if (exe.isTerminated()) {
				System.out.println("结束了！");
				break;
			}
			Thread.sleep(200);
		}

		long end = System.currentTimeMillis();
		System.out.println("It ran in: " + (end - start) + " ms");
	}
}
