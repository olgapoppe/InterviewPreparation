package ordered_tasks;

import java.util.HashMap;
import java.util.ArrayDeque;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
	
	public static void main (String [] args) {
		
		//Creating shared object, producer progress and latch 
		HashMap<Integer,ArrayDeque<EventRunPair>> runtaskqueues = new HashMap <Integer,ArrayDeque<EventRunPair>>();
		AtomicInteger producerProgress = new AtomicInteger(0);
		CountDownLatch latch = new CountDownLatch(args.length);		
		
		//Creating producer and consumer threads
		Thread prodThread = new Thread(new Producer(runtaskqueues, producerProgress, latch, args));
	    Thread consThread = new Thread(new Consumer(runtaskqueues, producerProgress, latch));

	    //Starting producer and consumer threads
	    prodThread.start();
	    consThread.start();			
	}
}
