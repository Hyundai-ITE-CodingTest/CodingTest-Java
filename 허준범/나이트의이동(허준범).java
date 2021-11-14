import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class ChessXY {
	public ChessXY(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}

	int x, y, cnt;
}

public class Main {

	public static int movecnt;
	public static int[][] move = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 },
			{ -2, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			int m = Integer.parseInt(bf.readLine());
			int[][] chessboard = new int[m][m];
			boolean[][] visited = new boolean[m][m];
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(bf.readLine());
			int finalX = Integer.parseInt(st.nextToken());
			int finalY = Integer.parseInt(st.nextToken());
			movecnt = Integer.MAX_VALUE;
			// 체스판 너비우선탐색 실행
			bfs(chessboard, visited, m, startX, startY, finalX, finalY);
			sb.append(movecnt).append('\n');
		}

		System.out.println(sb);
	}

	public static void bfs(int[][] chessboard, boolean[][] visited, int m, int startX, int startY, int finalX,
			int finalY) {
		Queue<ChessXY> q = new LinkedList<>();
		q.add(new ChessXY(startX, startY, 0));
		visited[startX][startY] = true;

		while (!q.isEmpty()) {

			ChessXY curr = q.remove();
			// 목표한 위치라면 최소이동거리 저장
			if (curr.x == finalX && curr.y == finalY) {
				movecnt = Math.min(movecnt, curr.cnt);
			}

			// 이동할 수 있는 칸으로 이동
			for (int i = 0; i < move.length; i++) {
				int nx = curr.x + move[i][0];
				int ny = curr.y + move[i][1];

				if (nx < 0 || ny < 0 || nx >= m || ny >= m || visited[nx][ny])
					continue;

				visited[nx][ny] = true;
				q.add(new ChessXY(nx, ny, curr.cnt + 1));
			}
		}
	}
}
