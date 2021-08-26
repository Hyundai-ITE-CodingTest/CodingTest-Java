package week05;

import java.io.*;
import java.util.Stack;

public class 오큰수_17298 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {

		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		Stack<Integer> stack = new Stack<Integer>();
		int[] answer = new int[N];
		String[] str = br.readLine().split(" ");
		
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(str[i]);
		}
		
		for(int i=N-1; i>=0; i--) {
			while (!stack.empty() && stack.peek() <= input[i]) {//오른쪽에 나보다 큰 값이 나올때 까지 pop
				stack.pop();
			}
			if (stack.empty()) { //1. 오른쪽에 더 큰 값이 없으면
				answer[i] = -1;
			} else {
				answer[i] = stack.peek(); //2. 오른쪽에 가장 큰 값
			}
			stack.push(input[i]); //검사값 스택에 푸쉬
		}
		
		for (int i = 0; i < N; i++) {
			bw.write(String.valueOf(answer[i]) + " ");
		}		

		bw.flush();
		bw.close();
		br.close();
	}
}
