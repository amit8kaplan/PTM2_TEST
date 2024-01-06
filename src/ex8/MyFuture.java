////package ex8;
////
////
////import java.util.function.Consumer;
////import java.util.function.Function;
////
////public class MyFuture<V> {
////	private V v =null;
////
////	Runnable task;
////	public <B> MyFuture<B> thenDo(Function<V, B> vrFunction) {
////		MyFuture<B> bMyFuture = new MyFuture<B>();
////		task = ()->bMyFuture.set(vrFunction.apply(v));//this is only declaration of object- its take o(1) run
////		return bMyFuture;
////
////	}
////	public void finallyDo(Consumer<V> vConsumer) {
////		task =()->vConsumer.accept(this.v);//only delaration
////	}
////
////
////	public synchronized void set(V s) {
////		this.v = s;
////		task.run(); // this is will run the o(1) in task in thenDo. its writen here because this.v=s will promise as that we have the v
//////		notifyAll();//whant to relesae all
////
////	}
////	public V get(){
////		if (v== null) {
////			synchronized (this) {
////				try {
////					if (v==null)
////						wait();
////				} catch(InterruptedException e){
////					throw new RuntimeException(e);
////				}
////			}
////		}
////		return v;
////	}
////
////
////	// implement set()
////
////	// implement thenDo()
////
////
////	// implement finallyDo()
////}
//
//
//
//
//
//
//
//
//
//
//package ex8;
//
//import java.util.function.Consumer;
//import java.util.function.Function;
//
//public class MyFuture<V> {
//	private V v;
//	Runnable r;
//
//	public void set(V v) {
//		this.v=v;
//		r.run();
//	}
//
//	public <R> MyFuture<R> thenDo(Function<V, R> f){
//		MyFuture<R> mf=new MyFuture<>();
//		r=()->mf.set(f.apply(v));
//		return mf;
//	}
//
//	public void finallyDo(Consumer<V> c) {
//		r=()->c.accept(v);
//	}
//}
