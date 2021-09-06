import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int N, S, result;
	public static int[] arr;

	public static void main(String[] args) throws IOException {
		// https://log-laboratory.tistory.com/119
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0);
		if (S == 0) // count 합이 0인 경우 공집합도 포함되므로 그 수를 하나 빼주고 출력
			result--;

		System.out.println(result);
	}

	public static void dfs(int depth, int sumVal) {
		if (depth == N) { // dfs로 돌며 누적시키다가 위치를 나타내는 v이 마지막 위치로 오면 원하는 값인지 아닌지 체크하여 count
			if (sumVal == S)
				result++;
			return;
		}

		// 부분수열, 지금 위치의 원소를 선택하거나, 선택하지 않거나
		dfs(depth + 1, sumVal + arr[depth]); // 지금 위치의 원소를 선택
		dfs(depth + 1, sumVal); // 선택하지 않음.
	}
}
