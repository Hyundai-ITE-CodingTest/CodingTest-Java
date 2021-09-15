package code9_14;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 절대값힙 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) == Math.abs(o2)) { 
					return Integer.compare(o1, o2); 
				}
				return Integer.compare(Math.abs(o1), Math.abs(o2)); 
			}
		});


		// 1<= N <= 100,000
		int N = input.nextInt();

		for (int i = 0; i < N; i++) {
			int X = input.nextInt();
			if (X != 0) {
				q.offer(X);
			}
			if (X == 0) {
				if (!q.isEmpty())
					System.out.println(q.poll());
				else {
					System.out.println(0);
				}
			}
		}

	}

}
