package producer_consumer_blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Producer extends Thread {
	
	private final BlockingQueue<Long> sharedQueue;

	public Producer(final BlockingQueue<Long> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
    	
		for (int i = 0; i<10; i++) {
			try {
				
				sharedQueue.put(Long.valueOf(i));

			} catch (final InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		
		
		
		System.out.println("Producer is done");
	}
}