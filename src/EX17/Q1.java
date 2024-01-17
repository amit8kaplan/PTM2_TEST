package ex17;

import java.util.concurrent.*;

public class Q1 {
    private static class MyFuture<V> implements Future<V> {

        V v=null;
        volatile boolean cancelled;
        public synchronized void set(V v){
            this.v = v;
            notifyAll();
        }

        @Override
        public synchronized boolean cancel(boolean mayInterruptIfRunning) {
            if (v!=null)
                return false;
            notifyAll();
            cancelled = true;

            return cancelled;
        }

        @Override
        public synchronized boolean isCancelled() {
            return cancelled;
        }

        @Override
        public synchronized boolean isDone() {
            if (v==null){
                return false;
            }
            return true;
        }

        @Override
        public synchronized V get() throws InterruptedException, ExecutionException {

            if (v ==null)
            {
                synchronized (this){
                    try{
                        if (v==null)
                            wait();
                    }catch (InterruptedException e){}
                }
            }
            return v;
        }

        @Override
        public synchronized V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
			// no need to implement
            return null;
        }

    }
    
    Runnable runnable;
    public void execute(){
        if (runnable!=null)
            runnable.run();
    }

    public <V> Future<V> submit(Callable<V> c){

        MyFuture<V> future = new MyFuture<>();
        runnable=(()->{
            try {
                V v = c.call();
                future.set(v);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return future;
        }


}
