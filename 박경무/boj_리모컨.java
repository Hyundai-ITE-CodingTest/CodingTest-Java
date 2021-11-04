package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1107_리모컨_풀이참고 {
   static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   static boolean[] isBroken = new boolean[10];
   static int MIN = Integer.MAX_VALUE;
   public static void main(String[] args) throws IOException {
      String target = br.readLine();
      int val = Integer.parseInt(br.readLine());
      if(val!=0) {
         String[] arr = br.readLine().split(" ");
         for (int i = 0; i < arr.length; i++) {
            isBroken[Integer.parseInt(arr[i])]=true;
         }
      }
      int targetNum=Integer.parseInt(target);
      MIN = Math.min(MIN, Math.abs(100-targetNum));
      
      for (int i = 0; i <= 1000000; i++) {
         int buttonCnt=check(i);
         if(buttonCnt>=0) {
        	 System.out.println(i);
        	 System.out.println("---------");
            MIN = Math.min(MIN, Math.abs(targetNum-i)+buttonCnt);
            
         }
      }
      System.out.println(MIN);
      
   }
   static int check(int i) {
      String str = Integer.toString(i);
      for (int j = 0; j < str.length(); j++) {
         if(isBroken[(str.charAt(j)-'0'-0)]) {
            return -1;
         }
      }
      return str.length();
   }
   

}