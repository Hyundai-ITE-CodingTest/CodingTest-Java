import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato {
	public int x;
	public int y;

	public Tomato(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	public static int n, m;
	public static int[][] boxes;
	public static Queue<Tomato> q = new LinkedList<>();
	public static boolean[][] visited;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		boxes = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < m; j++) {
				int x = Integer.parseInt(st.nextToken());
				boxes[i][j] = x;
				if (x == 1) { // 익은 토마토 큐에 저장
					q.add(new Tomato(i, j));
					visited[i][j] = true;
				}
			}
		}

		bfs(); // 토마토 익도록 처리

		int answer = 0; // 초기값 0으로 설정
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (boxes[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				answer = Math.max(answer, boxes[i][j]); // 가장 오래 걸린 날 찾기
			}
		}

		System.out.println((answer - 1)); // 처음부터 모든 토마토가 익어있는 상황 -1
	} // main

	public static void bfs() {
		// 익은 토마토 처리
		while (!q.isEmpty()) {
			int size = q.size(); // 하루에 여러 토마토 처리

			for (int i = 0; i < size; i++) { // 그 날 토마토 처리
				Tomato v = q.remove();

				for (int j = 0; j < 4; j++) {
					int nx = v.x + dx[j];
					int ny = v.y + dy[j];

					if (nx < 0 || ny < 0 || nx >= n || ny >= m)
						continue;
					if (boxes[nx][ny] != 0 || visited[nx][ny] == true)
						continue;

					visited[nx][ny] = true;
					boxes[nx][ny] = boxes[v.x][v.y] + 1;
					q.add(new Tomato(nx, ny));
				}
			}
		}
	} // bfs
}
