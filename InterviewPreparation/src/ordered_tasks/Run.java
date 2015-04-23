package ordered_tasks;

import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class Run {
	
	int id;
	int time;
	int value;	
	LinkedBlockingQueue<Accident> accidents;
		
	Run (int i) {
		
		this.id = i;
		this.time = 0;
		this.value = 0;	
		this.accidents = new LinkedBlockingQueue<Accident>();
	}
	
	boolean readAccidents (int time, int runid) {
		  for (Accident a : accidents) {	    		
		   		if (a.detAppTime < time && (time <= a.clearAppTime || a.clearAppTime==-1)) {
		   			System.out.println(runid + " reads accidents at time " + time + " : true");
		   			return true;
		  }}
		  System.out.println(runid + " reads accidents at time " + time + " : false");
		  return false;		  
	}

	synchronized void writeAccidents (int start, int end, int runid) {	
			if (start!=-1) {
		   		Accident a = new Accident(start);
		   		accidents.add(a);	    
		   		System.out.println(runid + " writes accidents at time " + start + " : " + a.toString());
		   	} else {
		   		Accident a = getNotFinishedAccident();
		   		a.clearAppTime = end;	   
		   		System.out.println(runid + " writes accidents at time " + end + " : " + a.toString());
		   	}	     	
		}
		
	Accident getNotFinishedAccident () {
		for (Accident a : accidents) {
			if (a.clearAppTime==-1) return a;
		}
		return null;
	}
	
	public synchronized boolean getAccidentAhead(HashMap<Integer,Run> runs, int time) {
		
		for (int i=0; i<3; i++) {
			int runID = this.id+i;
			if (runID>0 && runs.containsKey(runID)) {
				Run runAhead = runs.get(runID);
				if (runAhead.readAccidents(time, this.id)) return true;
		}}
		return false;
	}
	
	public synchronized String updateAccidents (int time) {
		
		String state_change = "none";
		
		if (time==2) { 
			writeAccidents(time, -1, this.id); 
			state_change = "ACCICENT";
		} else {
		if (time==7) { 
			writeAccidents(-1, time, this.id);
			state_change = "NORMAL";
		}}		
		return state_change;
	}
	
	public synchronized String update (Event event, boolean accAhead) {	
		
		// Update time
		this.time = event.time;
					
		// Update value			
		this.value++;	
		
		// Update accidents
		String state_change = this.updateAccidents(event.time);		
		
		// Output
		String s = "Thread " + Thread.currentThread().getName() + 
				" updated the value of run " + this.id + 
				" to " + this.value + 
				" and state to " + state_change +
				" at time " + this.time;
		if (accAhead) s += ". Accident warning.";		
		System.out.println(s);	
		
		return state_change;
	}	
}
