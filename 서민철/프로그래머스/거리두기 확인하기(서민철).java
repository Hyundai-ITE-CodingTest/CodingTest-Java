import java.util.*;
import java.io.*;

class Solution {
	public class Pos {
		int y, x, w;

		public Pos(int y, int x, int w) {
			this.y = y;
			this.x = x;
			this.w = w;
		}
	}

	public int[] solution(String[][] places) {
		int[] answer = new int[5];

		// i는 강의실 번호
		for (int i = 0; i < places.length; i++) {
			char[][] map = new char[5][5];
			boolean[][] visited = new boolean[5][5];

			// 거리두기를 잘 지키고 있는가?
			boolean state = true;

			for (int y = 0; y < 5; y++) {
				for (int x = 0; x < 5; x++) {
					map[y][x] = places[i][y].charAt(x);
					visited[y][x] = false;
				}
			}

			for (int y = 0; y < 5; y++) {
				for (int x = 0; x < 5; x++) {
					if (state && map[y][x] == 'P') {
						// BFS
						state = BFS(y, x, map, visited);
					}
				}
			}

			if (state) {
				answer[i] = 1;
			} else {
				answer[i] = 0;
			}
		}

		return answer;
	}

	public boolean BFS(int y, int x, char[][] map, boolean[][] visited) {
		Queue<Pos> queue = new LinkedList<>();
		queue.add(new Pos(y, x, 0));
		visited[y][x] = true;

		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		while (!queue.isEmpty()) {
			Pos p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];

				if (visitable(ny, nx, visited)) {
					if (map[ny][nx] == 'P') {
						return false;
					} else if (map[ny][nx] == 'O') {
						visited[ny][nx] = true;
						if (p.w < 1) {
							queue.add(new Pos(ny, nx, p.w + 1));
						}
					}
				}
			}
		}

		return true;
	}

	public boolean visitable(int ny, int nx, boolean[][] visited) {
		return (0 <= nx) && (nx < 5) && (0 <= ny) && (ny < 5) && (!visited[ny][nx]);
	}
}