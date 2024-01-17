//package ex4;
//
//public class Q2 {
//
//	static double[] averageCols(double[][] data){
//
//		double avg[]=new double[data[0].length];
//        int len_data = data.length;
//        for (int row = 0; row < len_data; row++) {
//            int len_data_0_4 = data[0].length/4;
//            for (int col = 0; col < len_data_0_4; col++) {
//                avg[col] += data[row][col];
//                avg[col+len_data_0_4] += data[row][col+len_data_0_4];
//                avg[col+len_data_0_4*2] += data[row][col+len_data_0_4*2];
//                avg[col+len_data_0_4*3] += data[row][col+len_data_0_4*3];
//            }
//        }
//        for (int col = 0; col < data[0].length; col++) {
//            avg[col] /= len_data;
//        }
//		return avg;
//	}
//
//
//
//}
