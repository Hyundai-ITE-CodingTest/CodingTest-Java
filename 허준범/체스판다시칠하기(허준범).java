import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n, m;
	public static String[][] chessboard;
	public static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		chessboard = new String[n][m];

		for (int i = 0; i < n; i++) {
			chessboard[i] = bf.readLine().split("");
		}

		result = Integer.MAX_VALUE;
		// 체스판 (0,0) 위치부터 (n-8, m-8) 위치까지를 탐색
		for (int i = 0; i < n - 7; i++) {
			for (int j = 0; j < m - 7; j++) {
				result = Math.min(result, find_color(i, j));
			}
		}

		System.out.println(result);
	}

	public static int find_color(int i, int j) {
		int count_1 = 0;
		int count_2 = 0;

		for (int k = i; k < i + 8; k++) {
			for (int l = j; l < j + 8; l++) {
				if ((k + l) % 2 == 0) { // 짝수면 일정한 색 가짐
					if (!chessboard[k][l].equals("W"))
						count_1 += 1;
					if (!chessboard[k][l].equals("B"))
						count_2 += 1;
				} else { // 홀수면 다른 일정한 색을 가짐
					if (!chessboard[k][l].equals("B"))
						count_1 += 1;
					if (!chessboard[k][l].equals("W"))
						count_2 += 1;
				}
			}
		}

		// 둘 중 더 적게 바꿀 색상
		return Math.min(count_1, count_2);
	}
}
