package producer_consumer_latch;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;
import java.util.logging.Level;

class Producer implements Runnable {

    private final BlockingQueue<Integer> sharedQueue;
    CountDownLatch latch;

    public Producer(BlockingQueue<Integer> sharedQueue, CountDownLatch latch) {
        this.sharedQueue = sharedQueue;
        this.latch = latch;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            try {
                System.out.println("Produced: " + i);
                sharedQueue.put(i);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    }
}


