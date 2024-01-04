//package ex13;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.concurrent.BlockingQueue;
//
//public class TaskerList extends LinkedList<BlockingQueue<Runnable>> {
//
//	private static final long serialVersionUID = 1L;
//	LinkedList<BlockingQueue<Runnable>> runnableBlockingQueues = new LinkedList<>();
//	List<Thread> threads = new ArrayList<>();
//	volatile  boolean stop = false;
//	public void pollAll() {
//		int i=0;
//
//			for (BlockingQueue<Runnable> runnableBlockingQueue : runnableBlockingQueues) {
//				threads.add(new Thread(() -> {
//					for (Runnable runnable : runnableBlockingQueue) {
//						runnable.run();
//
//					}
//				}));
//				threads.get(i).start();
//				i++;
//			}
//
//	}
//
//
//	public void stopRunning() {
//		stop = true;
//		threads.forEach(t -> t.interrupt());
//
//	}
//
//	@Override
//	public void addLast(BlockingQueue<Runnable> runnableBlockingQueue) {
//		if (!stop)
//			runnableBlockingQueues.add(runnableBlockingQueue);
//	}
//}
