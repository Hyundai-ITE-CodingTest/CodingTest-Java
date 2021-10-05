package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point3d {
	public Point3d(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	int x;
	int y;
	int z;
}

public class 토마토_7569 {
	static int[] dx = { 1, -1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, 1, -1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };
	static int green = 0;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[][][] tomato = new int[H][N][M];
		Queue<Point3d> que = new LinkedList<Point3d>();

		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int m = 0; m < M; m++) {
					int temp = Integer.parseInt(st.nextToken());
					if (temp == 0)
						green++;
					if (temp == 1)
						que.add(new Point3d(m, n, h)); // 시작 토마토
					tomato[h][n][m] = temp - 1;
				}
			}
		}

		while (que.size() > 0) {
			Point3d cur = que.poll();
			for (int d = 0; d < 6; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				int nz = cur.z + dz[d];
				if (0 <= nx && nx < M && 0 <= ny && ny < N && 0 <= nz && 0 <= nz && nz < H && tomato[nz][ny][nx] == -1) { // 범위 검사
					tomato[nz][ny][nx] = tomato[cur.z][cur.y][cur.x] + 1; // 익히는 횟수 증가
					max = tomato[nz][ny][nx]; // 최대 횟수 저장
					que.add(new Point3d(nx, ny, nz));
					green--; // 토마토 익음
				}

			}
		}

		if (green == 0)
			System.out.println(max);
		else {// 안익은 토마토가 남았으면 -1
			System.out.println("-1");
		}
	}
}
