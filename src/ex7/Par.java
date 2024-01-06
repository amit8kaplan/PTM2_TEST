package test;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class Par {
    Thread thread;
    ArrayBlockingQueue<Thread> threadArrayBlockingQueue;
    int capacity;
    int count;

    public Par(int capacity) {
        this.capacity = capacity;
        threadArrayBlockingQueue = new ArrayBlockingQueue<>(capacity);
    }
    public <V> Future<V> fold(V[] buff, BinaryOperator<V> binaryOperator) {
        final CompletableFuture<V> future = new CompletableFuture<>();
        if (count <= capacity) {
            count++;
            Thread thread = new Thread(() -> {
                V result = buff[0];
                for (int i = 1; i < buff.length; i++) {
                    result = binaryOperator.apply(result, buff[i]);
                }
                future.complete(result);
            });
            threadArrayBlockingQueue.add(thread);
            thread.start();
        }
        return future;
    }

    public <R,V> Future<List<R>> map(V[] buff, Function<V , R> function) {
        final CompletableFuture<List<R>> futureList = new CompletableFuture<>();
        if (count <= capacity) {
            count++;
            Thread thread = new Thread(() -> {
                List<R> rList = new ArrayList<>();
                for (V item : buff) {
                    rList.add(function.apply(item));
                }
                futureList.complete(rList);
            });
            threadArrayBlockingQueue.add(thread);
            thread.start();
        }
        return futureList;

    }

    public void close(){
        count =0;
        for(Thread thread1 : threadArrayBlockingQueue)
            thread1.interrupt();
    }


    // implement fold
    // implement map
    // implement close
}
