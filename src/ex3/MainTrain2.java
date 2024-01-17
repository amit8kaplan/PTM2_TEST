//package ex3;
//
//import java.util.Arrays;
//import java.util.List;
//
//public class MainTrain2 {
//	public static void main(String[] args) {
//		List<Integer> list=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//		int c = Thread.activeCount(); //2
//		System.out.println(c);
//		ThreadCounter tc=new ThreadCounter();
//		tc.start();
////		System.out.println(Thread.activeCount());
//		System.out.println(Thread.getAllStackTraces() +"how much thread in the main");
//		int count = Q2.parallelCountIf(list, x->x%2==0, 2);
//		int numOfThreadsOpened=tc.stopAndGet();
//		if(numOfThreadsOpened!=c+2) // main + 2 threads
//			System.out.println("wrong number of open threads (-20)");
//		System.out.println(numOfThreadsOpened);
//		if(count!=5)
//			System.out.println("wrong number of elements counted (-20)");
//
//
//		System.out.println("done");
//	}
//
//}
