import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		// 몰라서 검색했습니다. DP 어려워요ㅠㅠ...
		// https://zoonvivor.tistory.com/114
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		int[][] arr;
		int[][] dp;
		String[] line;

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[n + 1][2];
			dp = new int[n + 1][2];
			for (int j = 0; j < 2; j++) {
				line = br.readLine().split(" ");
				for (int k = 1; k <= n; k++) {
					arr[k][j] = Integer.parseInt(line[k - 1]);
				}
			}

			dp[1][0] = arr[1][0];
			dp[1][1] = arr[1][1];

			for (int l = 2; l <= n; l++) {
				dp[l][0] = Math.max(dp[l - 1][1], dp[l - 2][1]) + arr[l][0];
				dp[l][1] = Math.max(dp[l - 1][0], dp[l - 2][0]) + arr[l][1];
			}

			sb.append(Math.max(dp[n][0], dp[n][1])).append('\n');
		}

		System.out.println(sb);
	}
}
