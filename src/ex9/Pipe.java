package ex9;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Pipe<E> implements Stoppable{

	BlockingQueue<E> blockingQueue;
	Consumer<E> consumer;
	Thread thread;
	volatile boolean stop;
	Stoppable next;

	public Pipe() {
		blockingQueue = new ArrayBlockingQueue<>(100);
		thread = new Thread(()->{
			while(!stop){
				try {
					if (consumer!=null) {
					consumer.accept(blockingQueue.take());}
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		});
		thread.start();
	}
	public void forEach (Consumer<E> action){
		this.consumer = action;
	}

	// and stop
	@Override
	public void stop() {
		stop = true;
		thread.interrupt();
		if (next!= null)
			next.stop();

	}
	public <R> Pipe<R> map(Function<E, R>function){
		Pipe<R> next = new Pipe<>();
		consumer = e -> {
			next.add(function.apply(e));
		};
		this.next = next;
		return next;
	}
	public Pipe<E> filter(Predicate<E> predicate) {
		Pipe<E> next = new Pipe<>();
		consumer = e -> {
			if (predicate.test(e))
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
}
