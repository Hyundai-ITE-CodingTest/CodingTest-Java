import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int lottoNum = 6; // 로또번호 개수
	public static int[] out;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(bf.readLine());
			int k = Integer.parseInt(st.nextToken());
			if (k == 0) // 종료
				break;

			out = new int[lottoNum];
			int[] s = new int[k];
			for (int i = 0; i < k; i++)
				s[i] = Integer.parseInt(st.nextToken());
			combi(0, 0, k, s);
			sb.append('\n');
		}

		System.out.println(sb);
	}

	public static void combi(int at, int depth, int m, int[] s) {
		if (depth == lottoNum) {
			for (int val : out) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = at; i < m; i++) {
			out[depth] = s[i];
			combi(i + 1, depth + 1, m, s);
		}
	}
}
