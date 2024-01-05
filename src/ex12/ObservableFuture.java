package ex12;//package ex12;

import java.util.Observable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public  class  ObservableFuture<V>  extends  Observable{
//    V v;
    Future<V> future;

    volatile boolean stop = false;
    public ObservableFuture(Future<V> future) {
        super();
        this.future = future;
        Thread thread = new Thread(()->{
            try {
                this.future.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
            super.setChanged();
            super.notifyObservers();
        });
        thread.start();
    }


    public V get() {
        if (this.future.isDone()) {
            try {
                return this.future.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }


    // implement CTOR

	// implement get
}
//import java.util.concurrent.*;
//
//public class ObservableFuture<V> {
//
//    private final Future<V> future;
//    private CompletableFuture<Void> completionNotifier;
//
//    public ObservableFuture(Future<V> future) {
//        this.future = future;
//        this.completionNotifier = new CompletableFuture<>();
//
//        // Start a background task to notify observers when the future is completed
//        CompletableFuture.runAsync(() -> {
//            try {
//                V result = future.get();
//                completionNotifier.complete(null); // Notify observers that the value is ready
//            } catch (InterruptedException | ExecutionException e) {
//                completionNotifier.completeExceptionally(e);
//            }
//        });
//    }
//
//    public V get()  {
//        // Wait until the value is ready or return null if it's not ready
//        if (completionNotifier.isDone()) {
//            try {
//                return future.get();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            } catch (ExecutionException e) {
//                throw new RuntimeException(e);
//            }
//        } else {
//            return null;
//        }
//    }
//
//    // Method to register observers
//    public void addObserver(Observer observer) {
//        completionNotifier.thenRun(observer);
//    }
//
//    // Sample Observer interface
//    public interface Observer extends Runnable {
//        // Custom observer logic can be added here
//    }
//}
