//package ex1;
//
//public class Q2 {
//
//	public static double px(double x, double[] vec){
//		int count=0;
//		int len = vec.length;
//		for(int i=0;i<len;i++)
//			if(x==vec[i])
//				count++;
//		return (double)count/len;
//	}
//
//	public static double log2(double x){
//		return Math.log10(x)/Math.log10(2);
//	}
//
//
//	public static double OPT_Hx(double[] vec){
//		double sum =0;
//		int len = vec.length;
//		for(int i=0;i<len;i++) {
//			double px = px(vec[i], vec);
//			sum += px * log2(px);
//		}
//		return -sum;
//
//	}
//}
