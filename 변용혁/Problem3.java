package ex01;

import java.util.*;

public class Problem3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		String str = Integer.toString(A*B*C);
		
		
		int[] num = new int [11];
		for(int i=0; i< str.length(); i++) {
			int x = (int)(str.charAt(i)) - '0';
			num[x] += 1;
		}
		
		for(int i=0; i<10; i++) {
			System.out.println(num[i]);
		}
	}
}
