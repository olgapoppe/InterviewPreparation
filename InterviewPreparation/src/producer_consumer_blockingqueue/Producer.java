package producer_consumer_blockingqueue;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Producer extends Thread {
		private boolean blnExit = false;
		private final List<Consumer> consumers;
		private final BlockingQueue<Long> sharedQueue;

	public Producer(final BlockingQueue<Long> sharedQueue, final List<Consumer> consumers) {
		this.sharedQueue = sharedQueue;
		this.consumers = consumers;
	}

	@Override
	public void run() {
    	long i = 0;

		////////////////////////////////////////////
		// PRODUCING THE OBJECTS TO BE CONSUMED
		////////////////////////////////////////////
		while (!blnExit) {
			try {
				i++;
				sharedQueue.put(Long.valueOf(i));

			} catch (final InterruptedException ex) {
					ex.printStackTrace();
			}
		}

		/////////////////////////////////
		// WAIT UNTIL THE QUEUE IS EMPTY
		/////////////////////////////////
		while (sharedQueue.size() > 0) {
			try {
				Thread.sleep(200);
				System.out.println("Producer waiting to end.");
			} catch (final InterruptedException e) {
				break;
			}
		}

		////////////////////////////////////////////
		// SEND TO ALL CONSUMERS THE EXIT CONDITION
		////////////////////////////////////////////
		for (final Consumer consumer : consumers) {
			consumer.setExitCondition(true);
		}
	}
}