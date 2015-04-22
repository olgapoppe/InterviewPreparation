package producer_consumer_pattern;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
	
	public static void main(String args[]){
	  
	     //Creating shared object and latch
	     BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>();
	     CountDownLatch latch = new CountDownLatch(10);
	 
	     //Creating Producer and Consumer Thread
	     Thread prodThread = new Thread(new Producer(sharedQueue, latch));
	     Thread consThread = new Thread(new Consumer(sharedQueue, latch));

	     //Starting producer and Consumer thread
	     prodThread.start();
	     consThread.start(); 
	}
}
