package ex02;

import java.util.*;

public class Problem2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		int num = sc.nextInt();
		int sum = 0;
		
		for(int i=start; i<=end; i++) {
			if(i % num == 0) {
				sum += i;
			}
		}
		
		System.out.println(sum);
	}
}
