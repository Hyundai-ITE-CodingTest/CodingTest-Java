package kosa.team3_day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class boj2164_카드2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
//		Stack<Integer> stack = new Stack();
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		while(q.size()>1) {
			q.poll();
			q.add(q.poll());
		}
		System.out.println(q.poll());

	}

}
