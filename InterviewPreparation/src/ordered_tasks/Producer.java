package ordered_tasks;

import java.util.HashMap;
import java.util.ArrayDeque;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
	
	private final HashMap<Integer,ArrayDeque<EventRunPair>> runtaskqueues;
	AtomicInteger producerProgress;
	CountDownLatch latch;
	String[] input;
	
	Producer (HashMap<Integer,ArrayDeque<EventRunPair>> r, AtomicInteger p, CountDownLatch l, String[] i) {
		runtaskqueues = r;
		producerProgress = p;
		latch = l;
		input = i;
	}
	
	public void run() {
		
		HashMap<Integer,Run> runs = new HashMap<Integer,Run>();
		int count = 0;
		
		for (int i=0; i<this.input.length; i++) {
			
			// Event
			int runid = Integer.parseInt(this.input[i]);
			int arrivalTime = count++;
			Event event = new Event(runid,arrivalTime);
			
			// Run
			Run run;        		
			if (runs.containsKey(runid)) {
				run = runs.get(runid);             			          			
			} else {
				run = new Run(runid);
				runs.put(runid, run);
			}			
			
			// Add event-run pair to the run's task queue
			EventRunPair pair = new EventRunPair(run, event, latch, runs);			 
			ArrayDeque<EventRunPair> runtaskqueue = runtaskqueues.get(runid);
		    if (runtaskqueue == null) {
		    	runtaskqueue = new ArrayDeque<EventRunPair>();
		    	runtaskqueues.put(runid, runtaskqueue);		        
		    }
		    runtaskqueue.add(pair);	
		    if (producerProgress.get()<arrivalTime) producerProgress.set(arrivalTime);
		    System.out.println("produced " + event.toString());
		}
		
		// Add "done" event to every run task queue
		Set<Integer> runids = runtaskqueues.keySet();		
		for (Integer runid : runids) {
			ArrayDeque<EventRunPair> runtaskqueue = runtaskqueues.get(runid);
			Run r = runs.get(runid);
			Event e = new Event(runid,-1);		
			EventRunPair done = new EventRunPair(r, e, latch, runs);
			runtaskqueue.add(done);
			System.out.println("produced " + e.toString());
		}
	}
}
