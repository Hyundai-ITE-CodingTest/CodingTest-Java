import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int[] solution(String[][] places) {
		int[] answer = new int[places.length];

		for (int t = 0; t < places.length; t++) {
			char[][] map = new char[5][5];
			boolean[][] visited = new boolean[5][5];
			// state가 true라면 더 이상 탐색할 필요가 없음을 의미한다.
			boolean state = false;

			for (int y = 0; y < 5; y++) {
				for (int x = 0; x < 5; x++) {
					map[y][x] = places[t][y].charAt(x);
					visited[y][x] = false;
				}
			}

			for (int y = 0; y < 5; y++) {
				for (int x = 0; x < 5; x++) {
					if (map[y][x] == 'P') {
						if (!check(y, x, map, visited)) {
							answer[t] = 0;
							state = true;
						}
					}

					if (state) {
						break;
					}
				}

				if (state) {
					break;
				}
			}

			if (state) {
				continue;
			}

			answer[t] = 1;
		}

		return answer;
	}

	// 현재 좌표를 중심으로 거리두기가 잘 되고 있는지를 반환한다.
	public boolean check(int start_y, int start_x, char[][] map, boolean[][] visited) {
		int X = 1;
		int Y = 0;

		int[] dirY = { -1, 1, 0, 0 };
		int[] dirX = { 0, 0, -1, 1 };

		Queue<int[]> queue = new LinkedList<int[]>();
		int[] pos = { start_y, start_x };
		visited[start_y][start_x] = true;
		queue.add(pos);

		while (!queue.isEmpty()) {
			// 현재 위치를 저장한다.
			int[] now_pos = queue.poll();
			for (int i = 0; i < 4; i++) {
				// 방문하려는 위치를 저장한다.
				int tmp_y = now_pos[Y] + dirY[i];
				int tmp_x = now_pos[X] + dirX[i];

				if (visitable(start_y, start_x, tmp_y, tmp_x, visited)) {
					// 방문이 가능한 위치에 사람이 앉아있다면
					if (map[tmp_y][tmp_x] == 'P') {
						// 거리두기가 잘 되지 않고 있는 것이다.
						return false;
					} else if (map[tmp_y][tmp_x] == 'O') {
						visited[tmp_y][tmp_x] = true;
						int[] tmp = { tmp_y, tmp_x };
						queue.add(tmp);
					}
				}
			}
		}

		return true;
	}

	public boolean visitable(int start_y, int start_x, int y, int x, boolean[][] visited) {

		// 이동이 불가능한 위치인가?
		if (0 > y || y >= 5 || 0 > x || x >= 5) {
			return false;
		}

		// 이미 방문한 노드인가?
		if (visited[y][x]) {
			return false;
		}

		// 맨해튼 거리가 3 이상인가?
		if (Math.abs(start_y - y) + Math.abs(start_x - x) >= 3) {
			return false;
		}

		return true;
	}
}