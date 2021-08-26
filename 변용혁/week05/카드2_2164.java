package week05;

import java.util.*;

public class 카드2_2164 {
	public static void main(String[] args) {
		
		int N = new Scanner(System.in).nextInt();
		Queue<Integer> que = new LinkedList<Integer>();
		
		for(int i=1; i<=N; i++) {
			que.offer(i);
		}
		
		while(que.size() > 1) {
			que.poll(); //맨 앞 제거
			que.offer(que.poll());
		}
		
		System.out.println(que.poll());
		
	}
}
