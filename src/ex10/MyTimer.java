//package test;
//
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.ScheduledThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//
//public class MyTimer  {
////
////	Timer timer;
////	volatile boolean isRun = false;
////	public MyTimer() {
////		timer = new Timer();
////	}
////
////
////
////	public void start(Runnable r, int timesPerSecond) throws Exception{
////		if (!isRun)
////		{
////			isRun = true;
////			timer.scheduleAtFixedRate(new TimerTask() {
////			@Override
////			public void run() {
////				r.run();
////				System.out.println("RUN" + r);
////			}
////			}, 0, 1000/timesPerSecond);
////
////		}
////		else{
////			throw new Exception("this timer already runs a task");
////		}
////	}
////
////	public void stop() {
////		if(isRun) {
////
////
////			timer.cancel();
////			timer.purge();
////		}isRun = false;
////	}
//   public ScheduledExecutorService ses;
//	volatile boolean isRun = false;
//	public MyTimer() {
////		ses = new ScheduledThreadPoolExecutor(1);
//		}
//
//
//
//	public void start(Runnable r, int timesPerSecond) throws Exception{
//		if (!isRun)
//		{
//			isRun = true;
//			ses = new ScheduledThreadPoolExecutor(1);
//			ses.scheduleAtFixedRate(r, 0,1000/timesPerSecond, TimeUnit.MILLISECONDS);
//		}
//		else{
//			throw new Exception("this timer already runs a task");
//		}
//	}
//
//	public void stop() {
//		if(isRun) {
//			ses.shutdownNow();
//		}
//		isRun = false;
//	}
//
//}
