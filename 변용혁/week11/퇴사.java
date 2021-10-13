package week11;

import java.io.*;
import java.util.*;

public class 퇴사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] time = new int[N];
		int[] pay = new int[N];
		int[] dp = new int[N + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			time[i] = t;
			pay[i] = p;
		}

		for (int i = 0; i < N; i++) {
			if (time[i] + i <= N) { // 일정안에 끝나면
				dp[i + time[i]] = Math.max(dp[i + time[i]], dp[i] + pay[i]); //i날 일을하고 다음에 일을 할 수 있을때 값을 갱신
			}

			dp[i + 1] = Math.max(dp[i], dp[i + 1]);//어제일을하고 오늘 안했어도 더 큰값을 저장한다.
		}

		bw.write(String.valueOf(dp[N]));
		bw.flush();
		bw.close();
		br.close();
	}
}
