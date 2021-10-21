import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] wines;
	static int[][] dp;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		wines = new int[N];
		dp = new int[4][N];

		for (int i = 0; i < N; i++) {
			wines[i] = Integer.parseInt(br.readLine());
		}

		calWines(0);
		int max1 = Math.max(dp[0][0], dp[1][0]);
		max1 = Math.max(max1, dp[2][0]);
		max1 = Math.max(max1, dp[3][0]);
        
		if(N == 1) { System.out.print(max1); return; }
        
		int max2 = Math.max(dp[0][1], dp[1][1]);
		max2 = Math.max(max2, dp[2][1]);
		max2 = Math.max(max2, dp[3][1]);

		/*
		 * for (int i = 0; i < 4; i++) { for (int j = 0; j < N; j++) {
		 * System.out.print(dp[i][j] + " "); } System.out.println(); }
		 */

		System.out.print(Math.max(max1, max2));
	}

	static void calWines(int n) {
		if (n == (N - 1)) {
			dp[0][n] = wines[n];
			dp[1][n] = wines[n];
			dp[2][n] = 0;
			dp[3][n] = 0;
			return;
		}
		if (n == (N - 2)) {
			dp[0][n] = wines[n];
			dp[1][n] = wines[n] + wines[n + 1];
			dp[2][n] = 0;
			dp[3][n] = wines[n + 1];
			return;
		}

		calWines(n + 1);

		int max = Math.max(dp[0][n + 2], dp[1][n + 2]);
		max = Math.max(max, dp[2][n + 1]);
		max = Math.max(max, dp[3][n + 1]);

		dp[0][n] = wines[n] + max;
		dp[1][n] = wines[n] + dp[0][n + 1];
		dp[2][n] = max;
		dp[3][n] = dp[0][n + 1];

	}

}
