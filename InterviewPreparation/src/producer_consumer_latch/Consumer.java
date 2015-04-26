package producer_consumer_latch;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;
import java.util.logging.Level;

class Consumer implements Runnable {

    private final BlockingQueue<Integer> sharedQueue;
    CountDownLatch latch;

    public Consumer (BlockingQueue<Integer> sharedQueue, CountDownLatch latch) {
        this.sharedQueue = sharedQueue;
        this.latch = latch;
    }
  
    @Override
    public void run() {
        while(latch.getCount()>0){
            try {
                System.out.println("Consumed: "+ sharedQueue.take());
                this.latch.countDown();
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
}


