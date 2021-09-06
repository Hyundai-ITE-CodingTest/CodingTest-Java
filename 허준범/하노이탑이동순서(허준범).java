import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		System.out.println((int) Math.pow(2, n) - 1); // 이동 횟수
		hanoi(n, 1, 3, 2);
		System.out.println(sb);
	}

	public static void hanoi(int n, int from_pos, int to_pos, int assist_pos) {
		if (n == 1) { // 원반 한 개를 옮기는 문제면 그냥 옮기면 됨
			sb.append(from_pos).append(' ').append(to_pos).append('\n');
			return;
		}

		// 원반 n - 1개를 assist_pos로 이동(to_pos를 보조 기둥으로)
		hanoi(n - 1, from_pos, assist_pos, to_pos);
		// 가장 큰 원반을 목적지로 이동
		sb.append(from_pos).append(' ').append(to_pos).append('\n');
		// assist_pos에 있는 원반 n-1개를 목적지로 이동(from_pos를 보조 기둥으로)
		hanoi(n - 1, assist_pos, to_pos, from_pos);
	}
}
