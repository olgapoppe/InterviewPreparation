package ordered_tasks;

public class Accident {
	
	int detAppTime;
	int clearAppTime;
	
	public Accident(int s) {
		this.detAppTime = s;
		this.clearAppTime = -1;
	}
	
	public String toString() {
		return this.detAppTime + " " + this.clearAppTime;
	}
}
