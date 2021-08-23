package ex03;

import java.util.*;

public class Problem3_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		int sum = 0;
		int temp;
		
		for(int i=0; i<7; i++) {
			temp = sc.nextInt();
			if(temp % 2 == 1) {
				list.add(temp);
				sum += temp;
			}
		}
		if(list.size() == 0) {
			System.out.println(-1);
		}
		else {
			System.out.println(sum);
			System.out.println(Collections.min(list));
		}
	}
}
