package producer_consumer_blockingqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerPattern {
		private final int queueCapacity = 200;
		private int numberOfThreads = 10;

	public static void main(final String args[]) {
		new ProducerConsumerPattern(20);
	}

	public ProducerConsumerPattern(final int numberOfThreads) {
		
		if (numberOfThreads <= 0 || numberOfThreads > 100) 
			throw new IllegalArgumentException("The number of threads should be a number between 1 and 100");

		this.numberOfThreads = numberOfThreads;

		// Create shared object
		final BlockingQueue<Long> sharedQueue = new LinkedBlockingQueue<Long>(queueCapacity);

		// Create and start the consumer threads
		final List<Consumer> consumers = new ArrayList<Consumer>();
		for (int i = 0; i <= this.numberOfThreads; i++) {
			final Consumer consThread = new Consumer(i, sharedQueue);
			consThread.start();
			consumers.add(consThread);
		}

		// Create and start the producer thread
		final Producer prodThread = new Producer(sharedQueue, consumers);
		prodThread.start();
	}
}