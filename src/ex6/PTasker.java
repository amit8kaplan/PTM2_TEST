package ex6;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.BinaryOperator;

public class PTasker {

	ExecutorService es;

	public PTasker() {
		es = Executors.newSingleThreadExecutor();
	}

	public  <V> Future<V> apply(List<V> buff, V identity, BinaryOperator<V> bo){
		Future<V> future1;
		future1 =  es.submit(()->{
			V res = identity;
			for (V element : buff)
				res = bo.apply(res, element);
			return res;

		});
		return future1;
	}
	
	public void close(){
		es.shutdown();
	}
}
