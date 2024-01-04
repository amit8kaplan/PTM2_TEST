package ex14;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

public class ParallelCounter {
    public static <E> int parallelCountIf(List<E> list, Predicate<E> predicate ,int thread_count) {

        AtomicInteger atomicInteger = new AtomicInteger(0);
        List<Thread> threadList = new ArrayList<>();

        int listLen = list.size();
        int sizeOfSubLists =listLen / thread_count;

        int indexSubStart =0;
        int indexSubEnd = sizeOfSubLists;


        for (int i=0; i<thread_count; i++)
        {
            List<E> sublist = list.subList(indexSubStart,indexSubEnd);
            threadList.add(new Thread(()->{
               for (E e : sublist){
                   if(predicate.test(e))
                       atomicInteger.incrementAndGet();
                   else
                       atomicInteger.decrementAndGet();
               }
            }));
            threadList.get(i).start();
            indexSubStart+=sizeOfSubLists;
            indexSubEnd +=sizeOfSubLists;
        }
        for (Thread thread : threadList){
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return atomicInteger.get();
    }


}
