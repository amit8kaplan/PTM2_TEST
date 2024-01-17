//package ex6;
//
//public class GoodCode {
//
//	private static double average(int[] array){
//        double sum2=0; // sum the values
//		double sum=0; // sum the values
//        int array_length = array.length>>1;
//		for(int i=0;i<array_length;i++) {
//            sum += array[i];
//            sum2+= array[i+array_length];
//        }
//		return (sum2+sum)/(array.length); // average
//	}
//
//	// returns the squared distance of each value from the average
////	public static double[] dists(int[] array){
////        improvecode();
////        return GoodCode.dists_new(array);
////	}
//    public static double[]dists (int[] array){
//        double[] r=new double[array.length];
//        double avg = average(array);
//        int r_length = r.length>>2;
//        for(int i=0;i<r_length;i++) {
//            if (array[i] > avg) {
//                r[i] = (array[i] - avg) * (array[i] - avg);
//                r[i+r_length] = (array[i+r_length] - avg) * (array[i+r_length] - avg);
//                r[i+r_length*2] = (array[i+r_length*2] - avg) * (array[i+r_length*2] - avg);
//                r[i+r_length*3] = (array[i+r_length*3] - avg) * (array[i+r_length*3] - avg);
//            }else {
//                r[i] = (avg - array[i]) * (avg - array[i]);
//                r[i+r_length] = (avg - array[i+r_length]) * (avg - array[i+r_length]);
//                r[i+r_length*2] = (avg - array[i+r_length*2]) * (avg - array[i+r_length*2]);
//                r[i+r_length*3] = (avg - array[i+r_length*3]) * (avg - array[i+r_length*3]);
//            }
//        }
//        return r;
//    }
////    public static void improvecode (){
////        int x[] = new int[100];
////        for (int i = 0; i < 100; i++) {
////         x[i] = (int) Math.random();
////        }
////        for(int i=0;i<=110000;i++)
////            dists_new(x);
////    }
//}
