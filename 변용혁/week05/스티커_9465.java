package week05;

import java.util.*;
import java.io.*;

public class 스티커_9465 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			sc.nextLine();
			int[][] sticker = new int[2][n];
			for (int j = 0; j < n; j++) {
				sticker[0][j] = sc.nextInt();
			}
			sc.nextLine();
			for (int j = 0; j < n; j++) {
				sticker[1][j] = sc.nextInt();
			}
			sc.nextLine();

			bw.write(Solution(n, sticker).toString());
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}

	static Integer Solution(int n, int[][] sticker) {

		if(n == 1) {
			return Math.max(sticker[0][0], sticker[1][0]); 
		}
		
		int[][] dp = new int[2][n];
		dp[0][0] = sticker[0][0];
		dp[1][0] = sticker[1][0];

		dp[0][1] = sticker[0][1] + dp[1][0];
		dp[1][1] = sticker[1][1] + dp[0][0];
		
		for(int i=1; i<n; i++) {
			
			dp[0][i] = sticker[0][i] + Math.max(dp[1][i-1], dp[1][i-2]);
			dp[1][i] = sticker[1][i] + Math.max(dp[0][i-1], dp[0][i-2]);
		}		

		return Math.max(dp[0][n-1], dp[1][n-1]); 
	}
}
