package ex14;
import java.util.concurrent.RecursiveTask;

public class LucasNumbers extends RecursiveTask<Integer> {


	int num;
	int res;
	public <E> LucasNumbers(int num) {
		this.num = num;
		this.res = 0;
	}

	public Integer compute() {
		if (this.num == 0)
			return 2;
		if(this.num ==1)
			return 1;

		LucasNumbers lucasNumbers1 = new LucasNumbers(num-1);
		lucasNumbers1.fork();
		LucasNumbers lucasNumbers2 = new LucasNumbers(num-2);

		return (lucasNumbers2.compute() + lucasNumbers1.join());
	}
	
}
