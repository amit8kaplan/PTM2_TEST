//package test;
//
//import java.util.List;
//import java.util.function.BinaryOperator;
//
//public class Q3good<V> {
//
//	List<V> data;
//
//	public Q3good(List<V> data) {
//		this.data=data;
//	}
//
//	public V fold(V identity,BinaryOperator<V> acc) {
//		V result=identity;
//		for(V v : data) {
//			result=acc.apply(result, v);
//		}
//		return result;
//	}
//}