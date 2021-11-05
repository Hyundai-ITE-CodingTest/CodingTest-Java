import java.util.*;
import java.io.*;

class Solution {
	static int AnswerN;
	static int N;
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static char[][] map;

	public static void main(String args[]) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new char[N][N];

			for (int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < N; x++) {
					map[y][x] = st.nextToken().charAt(0);
				}
			}

			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if (map[y][x] != 'X' && map[y][x] != 'H') {
						changeState(y, x, map[y][x]);
					}
				}
			}

			// printMap();

			StringBuilder sb = new StringBuilder();
			sb.append("#");
			sb.append(String.valueOf(t));
			sb.append(" ");
			sb.append(String.valueOf(countHouse()));

			bw.write(sb.toString());
			bw.newLine();
		}

		bw.flush();
		br.close();
		bw.close();
	}

	// (y, x) 좌표의 기지국이 주변의 집의 상태를 바꾼다.
	public static void changeState(int y, int x, char type) {
		int round;
		int[] dirY = { -1, 1, 0, 0 };
		int[] dirX = { 0, 0, -1, 1 };

		if (type == 'A') {
			round = 1;
		} else if (type == 'B') {
			round = 2;
		} else {
			round = 3;
		}

		for (int r = 1; r <= round; r++) {
			for (int i = 0; i < 4; i++) {
				int posY = y + (dirY[i] * r);
				int posX = x + (dirX[i] * r);

				if (visitable(posY, posX)) {
					map[posY][posX] = 'X';
				}
			}
		}
	}

	public static boolean visitable(int y, int x) {
		return (0 <= y) && (y < N) && (0 <= x) && (x < N) && (map[y][x] == 'H');
	}

	public static int countHouse() {
		int sum = 0;

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (map[y][x] == 'H') {
					sum += 1;
				}
			}
		}

		return sum;
	}

	public static void printMap() {
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				System.out.printf("%c ", map[y][x]);
			}
			System.out.println();
		}
	}
}
