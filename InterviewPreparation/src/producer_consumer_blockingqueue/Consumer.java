package producer_consumer_blockingqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

public class Consumer extends Thread {
	boolean done = false;
	private final int id;
	private final BlockingQueue<Long> sharedQueue;
	CountDownLatch secondCountDown;

	public Consumer(final int i, final BlockingQueue<Long> s, CountDownLatch c) {
		id = i;
		sharedQueue = s;
		secondCountDown = c;
	}
	
	public void terminate () {
		done = true;
	}
	
	@Override
	public void run() {
		final Random generator = new Random();

		while (!done) {
			try {
				if (sharedQueue.size() > 0) {
					
					Long head = sharedQueue.take();
					System.out.println("Consumer " + id + " consumed " + head);

					// TO BE REMOVED (ONLY SIMULATES RANDOM WORKING TIME)
					final long start = System.currentTimeMillis();
					Thread.sleep(generator.nextInt(1000) + 1000);	
					final long end = System.currentTimeMillis();	
					
					secondCountDown.countDown();
					
				} else {
					System.out.println("Consumer " + id + " checked for a new task");
					Thread.sleep(500);
				}
			} catch (final InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println("Consumer " + id + " is done");
	}
}