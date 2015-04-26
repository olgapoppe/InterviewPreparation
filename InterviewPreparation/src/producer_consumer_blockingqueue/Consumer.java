package producer_consumer_blockingqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread {
		boolean blnExit = false;
		private final int id;
		private final BlockingQueue<Long> sharedQueue;

	public Consumer(final int id, final BlockingQueue<Long> sharedQueue) {
		this.id = id;
		this.sharedQueue = sharedQueue;
	}

	public void setExitCondition(final boolean blnDoExit) {
		blnExit = blnDoExit;
	}

	@Override
	public void run() {
		final Random generator = new Random();

		while (!blnExit) {
			try {
				if (sharedQueue.size() > 0) {
					System.out.println("Consumer id:" + id + " sent email " + sharedQueue.take());

					// TO BE REMOVED (ONLY SIMULATES RANDOM WORKING TIME)
					final long start = System.currentTimeMillis();
					Thread.sleep(generator.nextInt(1000) + 1000);	
					final long end = System.currentTimeMillis();
				} else {
					Thread.sleep(500);
				}
			} catch (final InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println("Consumer " + id + " exiting");
	}
}