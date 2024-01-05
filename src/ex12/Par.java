package ex12;

import java.util.concurrent.RecursiveTask;

public class Par extends RecursiveTask<Integer> {

    BinTree binTree;

    public Par(BinTree binTree) {
        this.binTree = binTree;
    }

//    @Override
//    protected Integer compute() {
//        if (this.binTree.getLeft()!=null)
//        {
//            Par left = new Par(binTree.getLeft());
//            left.fork();
//            Par right = new Par(binTree.getRight());
//            return ( binTree.get()+ left.join() + right.compute() );
//        }
//        return this.binTree.get();
//
//    }
    @Override
    protected Integer compute() {
       if (this.binTree.left==null)
           return this.binTree.get();
       Par left = new Par(this.binTree.left);
       left.fork();

       Par right = new Par(this.binTree.right);

       return ( right.compute() +left.join() + this.binTree.get());

    }

//
//    @Override
//    protected Integer compute() {
//        if(binTree.getLeft()!=null && binTree.getRight()!=null) {
//            Par left=new Par(binTree.getLeft());
//            left.fork();
//            Par right=new Par(binTree.getRight());
//            return binTree.get()+right.compute()+left.join();
//        }
//        else
//            return binTree.get();
//    }
}