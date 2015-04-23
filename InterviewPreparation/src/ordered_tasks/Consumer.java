package ordered_tasks;

import java.util.HashMap;
import java.util.ArrayDeque;
//import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Consumer implements Runnable {
	
	private final HashMap<Integer,ArrayDeque<EventRunPair>> runtaskqueues;
	AtomicInteger producerProgress;
	CountDownLatch latch;	
		
	Consumer (HashMap<Integer,ArrayDeque<EventRunPair>> r, AtomicInteger p, CountDownLatch l) {
		runtaskqueues = r;
		producerProgress = p;
		latch = l;			
	}
	
	public void run() {
		
		//Creating thread pool
		ExecutorService executor = Executors.newFixedThreadPool(3);				
		
		while (this.latch.getCount() > 0) {			
			
			for (int runid=4; runid>0; runid--) {
				if (runtaskqueues.containsKey(runid)) {
					
					ArrayDeque<EventRunPair> runtaskqueue = runtaskqueues.get(runid);
					EventRunPair pair = runtaskqueue.peek(); 
					if (pair!=null && pair.time!=-1 && pair.color!=Color.gray) {
						if (pair.color==Color.black) {
							runtaskqueue.poll(); // this must happen after the execution is done
							System.out.println("consumed " + pair.event.toString());
							EventRunPair new_pair = runtaskqueue.peek();
							if (new_pair!=null && new_pair.time!=-1) pair=new_pair;
						}
						if (pair.color==Color.white && readPossible(runid, pair.time)) {
							pair.color=Color.gray;
							executor.execute(pair);	// sets pair color to black								
						}
					}
				}
			}
		}
		// Shut down the thread pool after all events are processed
		try {
			latch.await();
			executor.shutdown();
		} catch (InterruptedException e) { e.printStackTrace(); }	
	}
	
	public boolean readPossible (Integer runid, double time) {
		
		for (int i=1; i<3; i++) {
			
    		int runidAhead = runid+i;
    		
    		if (runtaskqueues.containsKey(runidAhead)) {
    			
    			ArrayDeque<EventRunPair> runTaskQueueAhead = runtaskqueues.get(runidAhead);
    			
    			if (runTaskQueueAhead.isEmpty() && producerProgress.get()<time) {
    				
    				return false;
    				
    			} else {
    				
    				int queuetime = runTaskQueueAhead.peek().time;
    				if (queuetime<time && queuetime!=-1) return false; 
    				
    		}} else {
    			if (runidAhead<=4 && producerProgress.get()<time) return false;    			
    	}}
    	return true;
    }
}
