package codingtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Card2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			queue.add(i+1);
		}
		
		int firstnext = 1;
		while(queue.size()> 1) {
			queue.poll();
//			System.out.println(first);
			firstnext = queue.poll();
			queue.add(firstnext);
		}
		
		System.out.println(firstnext);
	}

}
