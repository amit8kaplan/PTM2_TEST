//package ex7;
//
//import java.awt.Point;
//
//public class GoodCode {
//
//	private static double EucDistance(Point a, Point b){
//        return (a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y);
//	}
//
//	public static Point geoMedian(Point[] values){
//		int valLen = values.length;
//		double[] sum = new double[valLen];
//		for(int i=0;i<valLen;i++){
//			for(int j=i+1;j<valLen;j++){
//				double d=EucDistance(values[i], values[j]);
//				sum[i]+=d;
//				sum[j]+=d;
//			}
//		}
//		Point r=null;
//		double min=Double.MAX_VALUE;
//		int lensum = sum.length;
//		for (int i=0;i<lensum;i++){
//			if(min>sum[i]){
//				min=sum[i];
//				r=values[i];
//			}
//		}
//		return r;
//	}
//
//}
