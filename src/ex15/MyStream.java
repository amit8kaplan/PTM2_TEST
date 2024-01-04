package ex15;


import test.Stoppable;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStream<E> implements Stoppable {


    BlockingQueue<E> blockingQueue;
    Consumer<E> consumer;
    Thread thread;
    volatile boolean stop;
    Stoppable next;
    public MyStream (){
        blockingQueue = new ArrayBlockingQueue<>(100);
        thread = new Thread(()->{
            while (!stop){
                if(consumer!=null) {
                    try {
                        consumer.accept(blockingQueue.take());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        thread.start();
    }
	@Override
	public void stop() {
        stop= true;
        thread.interrupt();
        if (next!=null)
            next.stop();
	}

    public MyStream<E> filter(Predicate<E> predicate) {
        MyStream<E> next = new MyStream<>();
        consumer = e -> {
            if(predicate.test(e))
                next.add(e);
        };
        this.next = next;
        return next;
    }

    public void add(E abc) {
        try {
            blockingQueue.put(abc);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public <R> MyStream<R> map(Function<E, R> function) {
        MyStream<R> next = new MyStream<>();
        consumer = e -> {
          next.add(function.apply(e));
        };
        this.next = next;
        return next;
    }

    public void forEach(Consumer<E> consumer) {
        this.consumer = consumer;
    }



}
