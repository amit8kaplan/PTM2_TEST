package ex15;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class PooledThread {

	BlockingQueue<Runnable> runnables;
	private volatile boolean isRunning;
	public static AtomicReference<String> str = null;
	public PooledThread (){
		runnables=new LinkedBlockingDeque<>(100);

		new Thread(()->{
			Runnable task;
			try {
				while((task=runnables.poll(1, TimeUnit.SECONDS))!=null)
					task.run();
			} catch (InterruptedException e) {e.printStackTrace();}
		}).start();
	}

	public void add(Runnable task) {
		try {
			runnables.put (task);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
