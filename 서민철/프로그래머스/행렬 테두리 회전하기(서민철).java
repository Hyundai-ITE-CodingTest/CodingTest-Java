class Solution {
	public int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		int[][] map = new int[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				map[i][j] = i * columns + j + 1;
			}
		}

		int idx = 0;

		for (int[] query : queries) {
			int x1 = query[0] - 1;
			int y1 = query[1] - 1;
			int x2 = query[2] - 1;
			int y2 = query[3] - 1;

			answer[idx] = rotate(x1, y1, x2, y2, map);
			idx += 1;
		}

		return answer;
	}

	public void printMap(int[][] map) {
		System.out.println();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.printf("%d\t", map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public int rotate(int y1, int x1, int y2, int x2, int[][] map) {
		int minVal = map[y1][x1];
		// 유실되면 안되는 값을 임시로 저장하는 변수이다.
		int buf = map[y1][x1];
		// → 채우기
		for (int x = x1; x < x2; x++) {
			// 값을 백업해둔다.
			int tmp = map[y1][x + 1];
			// 저장해야 할 값(buf)을 저장한다.
			map[y1][x + 1] = buf;
			// buf 값을 기존에 백업해둔 값으로 초기화한다.
			buf = tmp;
			minVal = Math.min(buf, minVal);
		}
		// ↓ 채우기
		for (int y = y1; y < y2; y++) {
			int tmp = map[y + 1][x2];
			map[y + 1][x2] = buf;
			buf = tmp;
			minVal = Math.min(buf, minVal);
		}
		// ← 채우기
		for (int x = x2; x > x1; x--) {
			int tmp = map[y2][x - 1];
			map[y2][x - 1] = buf;
			buf = tmp;
			minVal = Math.min(buf, minVal);
		}
		// ↑ 채우기
		for (int y = y2; y > y1; y--) {
			int tmp = map[y - 1][x1];
			map[y - 1][x1] = buf;
			buf = tmp;
			minVal = Math.min(buf, minVal);
		}

		return minVal;
	}
}