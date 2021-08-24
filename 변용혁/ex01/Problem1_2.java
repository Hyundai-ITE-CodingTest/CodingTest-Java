package ex01;

import java.util.*;

public class Problem1_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		int sum = 0;
		
		for(int i=0; i<7; i++) {
			int temp = sc.nextInt();
			if(temp % 2 == 1) {
				sum += temp;
				list.add(temp);
			}
		}
		
		System.out.println(sum);
		System.out.println(Collections.min(list));
		
		
	}
}
