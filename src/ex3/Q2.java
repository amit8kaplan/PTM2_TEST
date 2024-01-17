//package ex3;
//
//import java.util.List;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.function.Predicate;
//
//public class Q2 {
//
//	public static <V> int parallelCountIf(List<V> list, Predicate<V> p,int numOfThreads){
//		AtomicInteger count=new AtomicInteger(0);
//		int psize=list.size()/numOfThreads;
//		Thread arr[]=new Thread[numOfThreads];
//		for(int i=0;i<numOfThreads;i++){
//			List<V> partList=list.subList(i*psize, (i+1)*psize);
//			arr[i]=new Thread(()->partList.forEach(
//					x-> {if(p.test(x)) count.incrementAndGet();}));
//
//			arr[i].start();
//		}
//
//		for(Thread t : arr)
//			try {t.join();} catch (InterruptedException e) {}
//		System.out.println(count.get() + "count");
//		return count.get();
//	}
//
//
//
//
//}
//



package ex3;


import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

public class Q2 {
	public static <E> int parallelCountIf(List<E> eList, Predicate<E> predicate, int num_of_thread) {

		ExecutorService es = Executors.newFixedThreadPool(num_of_thread);

		AtomicInteger count_res = new AtomicInteger(0);

		int start = 0;
		int psize = eList.size() / num_of_thread;

		for (int i = 0; i < num_of_thread; i++) {
			List<E> partList = eList.subList(i * psize, (i + 1) * psize);
			es.submit(() -> {
				partList.forEach(e -> {
					if (predicate.test(e)) {
						count_res.incrementAndGet();
					}
				});
			});
		}
		try {
			es.awaitTermination(3, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		es.shutdown();
		return count_res.get();
	}

//		public static <V> int parallelCountIf(List<V> list, Predicate<V> p,int numOfThreads){
//			AtomicInteger count=new AtomicInteger(0);
//			int psize=list.size()/numOfThreads;
//			Thread arr[]=new Thread[numOfThreads];
//			for(int i=0;i<numOfThreads;i++){
//				List<V> partList=list.subList(i*psize, (i+1)*psize);
//				arr[i]=new Thread(()->partList.forEach(
//						x-> {if(p.test(x)) count.incrementAndGet();}));
//
//				arr[i].start();
//			}
//
//			for(Thread t : arr)
//				try {t.join();} catch (InterruptedException e) {}
//
//			return count.get();
//		}
//
//
//	}
}
//
//
//
//
//}
////import java.util.List;
////import java.util.concurrent.ExecutorService;
////import java.util.concurrent.Executors;
////import java.util.concurrent.atomic.AtomicInteger;
////import java.util.function.Predicate;
////
////public class Q2 {
////	public static <E> int parallelCountIf(List<E> eList, Predicate<E> predicate, int num_of_thread) {
////		ExecutorService es = Executors.newFixedThreadPool(num_of_thread);
////		System.out.println(es.toString());
////		AtomicInteger count_res = new AtomicInteger(0);
////
////		int list_size = eList.size();
////		int sublist_size = list_size / num_of_thread;
////
////		for (int i = 0; i < num_of_thread; i++) {
////			int start = i * sublist_size;
////			int end = (i == num_of_thread - 1) ? list_size : (i + 1) * sublist_size;
////
////			List<E> finalList = eList.subList(start, end);
////
////			es.execute(() -> {
////				finalList.forEach(e -> {
////					if (predicate.test(e)) count_res.incrementAndGet();
////				});
////			});
////
////			System.out.println(es.toString() + "    " + i);
////		}
////
////		System.out.println(es.toString());
////		es.shutdown();
////
////		return count_res.get();
////	}
////}
