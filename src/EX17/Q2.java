package EX17;

public class Q2 extends Thread {
    Runnable task;

    volatile boolean busy;
    public synchronized boolean setTask(Runnable runnable) {
//        if(this.task!=null)
//            return false;
//        else{
//            this.task = runnable;
//            notify();
//            return busy= true;
//        }
        if(this.task==null) {
            this.task=runnable;
            notify();
            return true;
        }
        return false;
    }
    public void run(){
        while (!busy){
            if (task!=null)
                task.run();
            synchronized (this){
                if(!busy)
                {
                    task =null;
                    try {
                        wait();
                    } catch (InterruptedException e) {}

                }
            }
        }
    }

    public synchronized void close() {
        busy =true;
        notify();
    }


}

