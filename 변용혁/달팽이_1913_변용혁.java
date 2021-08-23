package codingtest;

import java.io.*;

public class 달팽이_1913_변용혁 {
	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int point = Integer.parseInt(br.readLine());

		int[][] board = new int[n][n];
		int x = 0, y = 0, d = 0;
		int nx, ny;
		int sx = 0, sy = 0;

		for (int i = n * n; i >= 1; i--) {
			board[y][x] = i;
			if (i == point) {
				sy = y;
				sx = x;
			}
			ny = y + dy[d % 4];
			nx = x + dx[d % 4];
			if (0 <= ny && ny < n && 0 <= nx && nx < n && board[ny][nx] == 0) {
				y = ny;
				x = nx;
			} else {
				d += 1;
				y = y + dy[d % 4];
				x = x + dx[d % 4];
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println((sy + 1 )+ " " + (sx + 1));
	}
}
