////package ex2;
////
////public class Q2 {
////
////    // the original code:
////	public static double avg(double[] x, int len){
////		double sum=0;
////		double sum2=0;
//		int len_2 = len>>1;
////		for(int i=0;i<len_2;i++) {
////			sum += x[i];
////			sum2 +=x[i+len_2];
////		}return (sum+sum2)/len;
////	}
////
////	public static double pearson(double[] x,double[] y){
////		if (x==y)
////			return 1;
////
////		int xlen = x.length;
////		int ylen = y.length;
////		if(xlen==ylen){
////			double avgx = avg(x, xlen);
////			double avgy = avg(y, ylen);
////			double sumXY=0, sumX=0, sumY=0;
////			for(int i=0;i<xlen;i++){
////				double xiMinusAvgX = x[i]-avgx;
////				double yiMinusAvgY = y[i]-avgy;
////				sumXY+=(xiMinusAvgX*yiMinusAvgY);
////				sumX+= (xiMinusAvgX*xiMinusAvgX);
////				sumY+= (yiMinusAvgY*yiMinusAvgY);
////			}
////			return sumXY/(Math.sqrt(sumX*sumY));
////		}
////		return 0;
////	}
////
////
////
////	public static void warmup(){
////		double[] x = new double[100];
////		double[] y = new double[100];
////		for(int i=0;i<100;i++){
////			x[i]=Math.random();
////			y[i]=Math.random();
////		}
////		for (int i = 0; i <= 100000; i++) {
////			pearson(x, y);
////		}
////	}
////
////}
