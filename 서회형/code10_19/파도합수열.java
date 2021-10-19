package code10_18;

import java.util.Scanner;

public class 파도합수열 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// 입력 받을 갯수
		int N = input.nextInt();
		long[] arr = new long[N];
		long[] answerCase = new long[100];
		answerCase[0] = 1;
		answerCase[1] = 1;
		answerCase[2] = 1;
		
		for(int i = 3; i < 100; i++) {
			answerCase[i] = answerCase[i-3] + answerCase[i-2];
		}
		for(int i = 0; i < N; i++) {
			int inputNum = input.nextInt();
			arr[i] = answerCase[inputNum-1];
			}
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
	}
	
	

}
