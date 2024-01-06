package ex7;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class Par2 {
    ExecutorService es;

    public Par2(int capacity) {
        es = Executors.newFixedThreadPool(capacity);
    }



    public <V> Future<V> fold(V[] buff, BinaryOperator<V> binaryOperator) {
        Future<V> future1;
        future1 = es.submit(()->{
            V v = buff[0];
            for (int i=1; i<buff.length; i++)
                v=binaryOperator.apply(v, buff[i]);
            return v;
        });
        return future1;
    }

    public <R,V> Future<List<R>> map(V[] buff, Function<V , R> function) {
        Future<List<R>> listFuture;
        listFuture = es.submit(()->{
            List<R> rList = new ArrayList<>();
            for (int i=0 ;i<buff.length; i++)
                rList.add(function.apply(buff[i]));
            return rList;
        });
        return listFuture;
    }

    public void close(){


        es.shutdown();
    }


    // implement fold
	// implement map
	// implement close
}
