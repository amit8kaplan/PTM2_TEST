/*
package ex6;


import java.util.concurrent.ConcurrentHashMap;

public class Singleton {


	static ConcurrentHashMap<String,Object> hashMap = new ConcurrentHashMap<>();
	public static <V> V getInstance(Class<V> c) throws Exception {

		if (!hashMap.contains(c.getName())) {
			synchronized (hashMap) {
				if (!hashMap.contains(c.getName())) {
					hashMap.put(c.getName(), c.newInstance());
				}
			}
		}
		return (V) hashMap.get(c.getName());
	}
		// recall:
		// c.newInstance() creates a new instance of type VMID
		// c.getName() returns a String - the name of type V
}
*/
