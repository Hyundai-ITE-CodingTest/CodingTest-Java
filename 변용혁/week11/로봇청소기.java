package week11;

import java.io.*;
import java.util.*;

public class 로봇청소기 {
	public static int[] dx = { 0, 1, 0, -1 };
	public static int[] dy = { -1, 0, 1, 0 };
	public static int[][] arr;
	static int N;
	static int M;
	static int answer = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		st = new StringTokenizer(br.readLine());
		int cy = Integer.parseInt(st.nextToken());
		int cx = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		DFS(cy, cx, d);

		System.out.println(answer);
	}

	public static void DFS(int cy, int cx, int d) {
		// 현재 위치를 청소한다.

		arr[cy][cx] = 2;
		int go = 0;

		for (int i = 0; i < 4; i++) {
			d--; // 왼쪽으로 꺽는다
			if (d < 0) {
				d = 3;
			}
			int ny = cy + dy[d]; // d 방향으로 간다
			int nx = cx + dx[d];

			if (0 <= ny && ny < N && 0 <= nx && nx < M && arr[ny][nx] == 0) {
				answer++; //청소하는 곳 개수 증가
				DFS(ny, nx, d);
				return; 
			}
		}
		//다음으로 못넘어가면 후진
		int ny = cy - dy[d]; // d반대 방향으로 감
		int nx = cx - dx[d];

		if (0 <= ny && ny < N && 0 <= nx && nx < M && arr[ny][nx] != 1) {
			DFS(ny, nx, d);
		}
	}
}
