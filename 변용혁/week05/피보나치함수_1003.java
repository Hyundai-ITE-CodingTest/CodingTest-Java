package week05;

import java.io.*;
import java.util.*;

public class 피보나치함수_1003 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			Solution(Integer.parseInt(br.readLine()));
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	static void Solution(int n) throws IOException {
		
		
		if (n == 0) {
			bw.write("1 0");
			return;
		}
		if (n == 1) {
			bw.write("0 1");
			return;
		}
		
		int[][] dp = new int[2][n+1];
		
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		for(int i=2; i<=n; i++) {
			dp[0][i] = dp[0][i-1] + dp[0][i-2];
			dp[1][i] = dp[1][i-1] + dp[1][i-2];
		}
		bw.write(String.valueOf(dp[0][n]) + " " + String.valueOf(dp[1][n]));
		return;
	}
}
