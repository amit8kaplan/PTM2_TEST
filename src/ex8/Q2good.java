////
////package ex8;
////
////import java.util.ArrayList;
////import java.util.HashMap;
////import java.util.List;
////
////public class Q2good {
////	List<Double> X,Y;
////    HashMap<Double, ArrayList<Integer>> indices=new HashMap<>();
////
////	public Q2good(List<Double> X, List<Double> Y) {
////		this.X=X;
////		this.Y=Y;
////	}
////
////
////	// probability to see yj in Y
////	private double Py(double yj) {
////        double count=0;
////        for(int i=0;i<Y.size();i++)
////            if(Y.get(i)==yj)
////                count++;
////        return count/Y.size();
////	}
////
////	// probability to see xi and yj in X and Y
////	private double Pxy(double xi, double yj) {
////		double count=0;
////        ArrayList<Integer> index = indices.get(xi);
////        int index_size = index.size();
////        for(int i=0;i<index_size;i++)
////            if(Y.get(index.get(i))==yj)
////                count++;
////        return count/X.size();
////	}
////	public double conditionalEntropy() {
////		double sum=0;
////        int lenX = X.size();
////        int lenY = Y.size();
////        double py[] = new double [lenY];
////
////        for (int i=0; i<py.length; i++)
////            py[i] = Py(Y.get(i));
////
////        for(int i=0; i<X.size(); i++){
////            if(!indices.containsKey(X.get(i)))
////                indices.put(X.get(i), new ArrayList<Integer>());
////            indices.get(X.get(i)).add(i);
////        }
////
////        for (int i=0; i<X.size(); i++){
////            for (int j =0; j<Y.size(); j++){
////                double Pxy = Pxy(X.get(i), Y.get(j));
////                if(Pxy>0)
////                    sum+=Pxy*Math.log10(Pxy/py[j]);
////            }
////        }
////		return -sum/Math.log10(2);
////	}
////}
//
//
//
//
//package ex8;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//public class Q2good {
//    List<Double> X,Y;
//    HashMap<Double, ArrayList<Integer>> indices=new HashMap<>();
//
//    public Q2good(List<Double> X, List<Double> Y) {
//        this.X=X;
//        this.Y=Y;
//    }
//
//
//    // probability to see yj in Y
//    private double Py(double yj) {
//        double count=0;
//        for(int i=0;i<Y.size();i++)
//            if(Y.get(i)==yj)
//                count++;
//        return count/Y.size();
//    }
//
//    // probability to see xi and yj in X and Y
//    private double Pxy(double xi, double yj) {
//        double count=0;
//        ArrayList<Integer> index = indices.get(xi);
//        int index_size = index.size();
//        for(int i=0;i<index_size;i++)
//            if(Y.get(index.get(i))==yj)
//                count++;
//        return count/X.size();
//    }
//    public double conditionalEntropy() {
//        double sum=0;
//        int lenX = X.size();
//        int lenY = Y.size();
//        double py[] = new double [lenY];
//
//        for (int i=0; i<py.length; i++)
//            py[i] = Py(Y.get(i));
//
//        for(int i=0; i<X.size(); i++){
//            if(!indices.containsKey(X.get(i)))
//                indices.put(X.get(i), new ArrayList<Integer>());
//            indices.get(X.get(i)).add(i);
//        }
//
//        for (int i=0; i<X.size(); i++){
//            for (int j =0; j<Y.size(); j++){
//                double Pxy = Pxy(X.get(i), Y.get(j));
//                if(Pxy>0)
//                    sum+=Pxy*Math.log10(Pxy/py[j]);
//            }
//        }
//        return -sum/Math.log10(2);
//    }
//}
