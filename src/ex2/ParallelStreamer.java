package ex2;


import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Consumer;

public class ParallelStreamer<E> {
	ArrayList<BlockingQueue<E>> arrayList;
	int size;
	int round;
	volatile boolean stop;
	Thread[] threads;
	public ParallelStreamer(int size, int capacity, Consumer<E> eConsumer) {
		this.round =0;
		this.size = size;
		this.arrayList = new ArrayList<>();
		this.threads = new Thread[size];
		for (int i=0; i<size; i++)
			 {
				 BlockingQueue<E> blockingQueue = new ArrayBlockingQueue<>(capacity);
				 arrayList.add(blockingQueue);
				 threads[i] = new Thread(()->{
					 while (!stop) {
						 try {
							 eConsumer.accept(blockingQueue.take());
						 } catch (InterruptedException e) { }
					 }
				 });
				 threads[i].start();
		}
	}
		
	
	public void add(E e) throws InterruptedException{
		if (!this.stop){
			this.arrayList.get(this.round).put(e);
			this.round=(this.round+1)%this.size;
		}
	}
	
	public void endOfInput(){
		stop = true;
		for (Thread thread: threads)
			thread.interrupt();
		}
}


