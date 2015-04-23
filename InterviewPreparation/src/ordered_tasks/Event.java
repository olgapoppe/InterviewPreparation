package ordered_tasks;

public class Event {
	
	int id;
	int time;
	
	
	Event (int i, int t) {
		this.id = i;
		this.time = t;		
	}
	
	public String toString() {
		return this.id + " " + this.time;
	}
}
