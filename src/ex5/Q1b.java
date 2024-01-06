package ex5;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Q1b {

    BlockingQueue<Runnable> runnables = new LinkedBlockingDeque<>();
    Thread thread;
    volatile boolean stop = false;
    public Q1b() {
        thread = new Thread(()->{
           while(!stop)
           {
               try {
                   runnables.take().run();
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        });
        thread.start();
    }

    public void push(Runnable r){
        if (!stop) {
            try {
                runnables.put(r);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

	public void close(){
        runnables.add(()->stop = true);
	}
}