package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tasker extends HashMap<String, List<Runnable>> {

	private static final long serialVersionUID = 1L;
	List<Thread> threadList = new ArrayList<>();
	volatile boolean isAlive = false;

	public void start() {
		final int[] i = {0};
		isAlive = true;
		super.forEach((string, runnables)->{
			threadList.add(new Thread(()->
					runnables.forEach(runnable -> runnable.run()),string));
			threadList.get(i[0]).start();
			i[0]++;
		});
	}

	public void join() {
		threadList.forEach(thread -> {
			try {
				thread.join();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		});

	}
	@Override
	public List<Runnable> put(String key, List<Runnable> value) {
		if (!isAlive)
			return super.put(key, value);
		return null;

	}
}
