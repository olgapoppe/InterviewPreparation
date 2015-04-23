package ordered_tasks;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

public class EventRunPair implements Runnable {
	
	int time;
	Run run; // might be superficial
	Event event; // may be several for HP runs
	CountDownLatch latch;
	HashMap<Integer,Run> runs;
	Color color;
		
	EventRunPair (Run r, Event e, CountDownLatch l, HashMap<Integer,Run> rs) {
		this.time = e.time;
		this.run = r;	
		this.event = e;
		this.latch = l;
		this.runs = rs;
		this.color = Color.white;
	}
	
	public void run() {
				
		// read
		boolean accAhead = this.run.getAccidentAhead(this.runs, event.time);
		
		// write
		this.run.update(this.event, accAhead);			
		
		this.latch.countDown();
		this.color = Color.black;
	}
}
