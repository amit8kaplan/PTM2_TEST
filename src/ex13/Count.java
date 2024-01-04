package ex13;

import java.util.concurrent.atomic.AtomicInteger;

public class Count {
//	int[] countArr;
    AtomicInteger[] countArr;
	public Count(int size) {
		countArr = new AtomicInteger[size];
        for (int i = 0; i < countArr.length; i++) {
            countArr[i] = new AtomicInteger(0);
        }
//        Arrays.fill(countArr, 0);

	}

	public  void inc(){
		for (int i = 0; i < countArr.length; i++)
//			countArr[i]++;
	        countArr[i].incrementAndGet();
    }

	public  void dec() {
		for (int i = 0; i < countArr.length; i++)
//			countArr[i]--;
            countArr[i].decrementAndGet();
	}

	public int get(int index) {
//		return countArr[index];
	    return countArr[index].get();
    }
}
