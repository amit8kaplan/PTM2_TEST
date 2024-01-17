//package ex5;
//
//import java.util.ArrayList;
//
//public class Q2 {
//
//        public static int H_len (String a, String b){
//            int lenA = a.toCharArray().length;
//            int lenB = b.toCharArray().length;
//            if (lenA>lenB)
//                return lenA-lenB;
//            else
//                return lenB-lenA;
//        }
//		public static int H(String a, String b){
//		int sum=0;
//        char[] charA = a.toCharArray();
//        char[] charB = b.toCharArray();
//        int lenA = charA.length;
//        int lenB = charB.length;
//        if (lenA > lenB) {
//            for (int i = 0; i < lenB; i++)
//                if (charA[i] != charB[i])
//                    sum++;
//        sum+= lenA - lenB;
//        }else {
//            for (int j = 0; j < lenA; j++)
//                if (charA[j] != charB[j])
//                    sum++;
//            sum += lenB - lenA;
//        }
//        return sum;
//	}
//	// inefficent code. re-implement.
//	public static int findMinH(ArrayList<String> array){
//		int min=Integer.MAX_VALUE;
//        for (String a: array)
//            for (String b: array)
//                if (a != b) {
//                    if (a.equals(b))
//                        return 0;
//                    else if (H_len(a, b) ==1)
//                        return 1;
//                    else {
//                        int h = H(a, b);
//                        if (min > h)
//                            min = h;
//                    }
//                }
//		return min;
//	}
//}
