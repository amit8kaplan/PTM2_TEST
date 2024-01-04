//package EX16;
//
//
//import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.BlockingQueue;
//import java.util.function.Consumer;
//
//public class GenericActiveActor extends Actor implements Runnable{
//
////    private final BlockingQueue<String> msgq;
////    private final Consumer<String> msgc;
////    private boolean isRun;
////
////    public GenericActiveActor(int id, Consumer<String> consumer) {
////        super(id);
////        this.msgc = consumer;
////        this.msgq = new LinkedBlockingDeque<>(3);
////        this.isRun = true;
////        // START THE THREAD!
////        Thread thread = new Thread(this);
////        thread.start();
////    }
////
////    @Override
////    void addMessage(String msg) {
////        try {
////            msgq.put(msg);
////        } catch (InterruptedException e) {
////            throw new RuntimeException(e);
////        }
////    }
////
////    @Override
////    void close() {
////        isRun= false;
////        try {
////            msgq.put("stop");
////        } catch (InterruptedException e) {
////            throw new RuntimeException(e);
////        }
////
////    }
////
////    @Override
////    public void run() {
////        while(isRun){
////            try {
////                String msg = msgq.take();
////                if (msg.equals("stop"))
////                    isRun =false;
////            } catch (InterruptedException e) {
////                throw new RuntimeException(e);
////            }
////
////        }
////
////    }
//
//    BlockingQueue<String> bq = new ArrayBlockingQueue<>(3);
//    volatile boolean stop=false;
//    public GenericActiveActor(int id, Consumer<String> consumer) {
//        super(id);
//        Thread thread =new Thread(()-> {
//            while (!stop) {
//                try {
//                    String msg = bq.take();
//                    if (msg.equals("stop"))
//                        stop =true;
//                    else
//                        consumer.accept(msg);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//
//            }
//        });
//        thread.start();
//
//    }
//
//    @Override
//    void addMessage(String msg) {
//        try {
//            bq.put(msg);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    void close() {
//        addMessage("stop");
//    }
//}
