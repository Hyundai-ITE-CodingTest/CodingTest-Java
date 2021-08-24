package ex02;

import java.util.*;

public class Problem2_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum = 0;
		
		List<Integer> score = new ArrayList<Integer>();
		
		for(int i =0 ; i<N; i++) {
			score.add(sc.nextInt());
		}
		sc.nextLine();
		
		String obst1 = sc.nextLine();
		String obst2 = sc.nextLine();

		for(int i =0 ; i<N; i++) {
			if(obst1.charAt(i) == 'O' && obst2.charAt(i) == 'O') {
				sum += score.get(i);
			}
		}
		
		System.out.println(sum);
	}
}
