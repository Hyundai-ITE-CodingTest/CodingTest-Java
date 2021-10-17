package code10_13;

import java.util.Scanner;

public class 퇴사 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		
		int a  = 0;
		int b  = 0;
		int [] d = new int[22]; 
		
		for(int i = 0; i < N; i++) {
			 a = input.nextInt();
			 b = input.nextInt();
			 d[i+1] = max(d[i+1], d[i]);
			 d[i + a] = max(d[i + a], d[i] + b);
			
		}
		System.out.println(d[N]);
		
	}
	
	public static int max(int a, int b) {
		
		return a > b ? a : b; 
	}

}
