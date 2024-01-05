package test;

import java.util.concurrent.RecursiveTask;

public class ParMaxSearcher extends RecursiveTask<Integer> {

	private static final long serialVersionUID = 1L;
    int max;
    BinTree root;

    public ParMaxSearcher(BinTree root) {
        this.root = root;
        this.max =0;
    }

    @Override
	protected Integer compute() {
		if (this.root.left==null)
            return Math.max(max, this.root.get());
        ParMaxSearcher left = new ParMaxSearcher(this.root.left);
        left.fork();

        ParMaxSearcher right = new ParMaxSearcher(this.root.right);
        return Math.max(right.compute(), left.join());
	}

}
