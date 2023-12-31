package EX18;

import java.util.concurrent.RecursiveTask;

public class Q2  extends RecursiveTask<Integer> {
    int[] data;
    int max;
    public Q2(int[] data){
        this.data=data;
        this.max =0;
    }

    @Override
    protected Integer compute() {

        if (this.data.length==2) {
            if (this.data[0] > this.data[1])
                return this.data[0];
            else
                return this.data[1];
        }
        if (this.data.length ==1)
            return this.data[0];

        int[] left = new int[this.data.length];
        int[] right = new int[this.data.length];
        for (int i = 0; i <this.data.length/2 ; i++)
        {
            left[i]=data[i];
            right[i+this.data.length/2]=data[i+this.data.length];
        }
        Q2 qr = new Q2(right);
        qr.fork();
        Q2 ql = new Q2(left);
        return Math.max(ql.compute(), qr.join());
    }
}
