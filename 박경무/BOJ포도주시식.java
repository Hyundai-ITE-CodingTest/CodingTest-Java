import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
//https://www.acmicpc.net/problem/2156
//https://hidelookit.tistory.com/130
public class BOJ포도주시식 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[] cur = new int[N+1]; 
		int[] dp= new int[N+1]; 
		
		for(int i =1; i<=N; i++) {
			cur[i]=Integer.parseInt(br.readLine());
		}
		
		dp[1]=cur[1];
		if(N>=2) {
			dp[2]=cur[2]+dp[1];
		}
		for (int i = 3; i <= N; i++) {
			dp[i]=Math.max(dp[i-1], dp[i-2]+cur[i]);
			dp[i]=Math.max(dp[i], dp[i-3]+cur[i-1]+cur[i]);
		}
		System.out.println(dp[N]);
		
	}

}
