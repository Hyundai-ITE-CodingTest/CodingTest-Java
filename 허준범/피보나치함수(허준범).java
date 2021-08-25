import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		// n이 0부터 증가할 때, 0과 1을 출력하는 표를 적어보자..
		// 풀었었는데도 몰라서 검색해봄.
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(bf.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		int[] zero = new int[41];
		int[] one = new int[41];

		zero[0] = 1;
		zero[1] = 0;
		one[0] = 0;
		one[1] = 1;

		for (int i = 2; i < 41; i++) {
			zero[i] = zero[i - 1] + zero[i - 2];
			one[i] = one[i - 1] + one[i - 2];
		}

		for (int i = 0; i < n; i++) {
			sb.append(zero[arr[i]]).append(' ').append(one[arr[i]]);
			sb.append('\n');
		}

		System.out.println(sb);
	}
}
