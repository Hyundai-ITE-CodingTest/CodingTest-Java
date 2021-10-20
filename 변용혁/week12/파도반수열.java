import java.io.*;

public class Main {
	static long[] dp = new long[101];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 2;
		dp[4] = 2;
		
		for (int i = 5; i < 101; i++) {
			dp[i] = dp[i-1] + dp[i-5];
		}

		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			bw.write(String.valueOf(dp[n-1]));
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
