package boj.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_2156 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] wine = new int[n+1];
		int[] dp = new int[n+1]; // 현재까지 선택된 포도주 양에 대한 최대합
		
		for(int i = 1; i<=n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = wine[1];
		if(n>1) {//추가안하면 런타임에러
			dp[2] = dp[1] + wine[2];
		}
		for(int i = 3; i<=n; i++) {
			dp[i] = Math.max(dp[i-2] + wine[i], dp[i-3] + wine[i-1] + wine[i]);
			dp[i] = Math.max(dp[i-1], dp[i]);
		}
		System.out.println(dp[n]);
		br.close();
	}
}
