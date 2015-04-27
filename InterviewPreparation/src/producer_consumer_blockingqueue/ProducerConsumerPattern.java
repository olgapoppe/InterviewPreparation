package producer_consumer_blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerPattern {
	
	public static void main(final String args[]) {
		
		// Create shared object
		final BlockingQueue<Long> sharedQueue = new LinkedBlockingQueue<Long>();
		CountDownLatch secondCountDown = new CountDownLatch(10);

		// Create and start the consumer threads
		final Consumer consThread1 = new Consumer(1, sharedQueue, secondCountDown);
		final Consumer consThread2 = new Consumer(2, sharedQueue, secondCountDown);
		consThread1.start();
		consThread2.start();		

		// Create and start the producer thread
		final Producer prodThread = new Producer(sharedQueue);
		prodThread.start();
		
		// Terminate consumer threads
		try {
			secondCountDown.await();
			
			consThread1.terminate();
			consThread2.terminate();
		} catch (InterruptedException e) { e.printStackTrace(); }
	}
}