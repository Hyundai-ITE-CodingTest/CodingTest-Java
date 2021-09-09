import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Tomato {
	static Queue<Position> queue = new LinkedList<Position>();
	static int M, N;
	static int[] moveY = { 1, -1, 0, 0 }; // 상, 하 , 좌 , 우
	static int[] moveX = { 0, 0, -1, 1 };
	static int[][] board;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] xy = br.readLine().split(" ");
		M = Integer.parseInt(xy[0]);
		N = Integer.parseInt(xy[1]);
		int day = 0;
		
		board = new int[N][M];
		
		// Board 만들기
		for (int y = 0; y < N; y++) {
			String line = br.readLine();
			String[] Ms = line.split(" ");
			for (int x = 0; x < M; x++) {
				board[y][x] = Integer.parseInt(Ms[x]);
			}
		}

		//확인
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				System.out.print(board[y][x]);
			}
			System.out.println("");
		}

		// 익은 토마토 넣기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 1) {
					queue.add(new Position(i, j));
					
				}
			}
		}
		int result = bfs();
		System.out.println("답" + result);
	}

	public static int bfs() {

		int day = 0;
		
		while (queue.size() > 0) {
			
			// 1 depth 탐색
			int curQsize = queue.size();
			while(curQsize > 0){
				
				--curQsize;
				Position red = queue.poll();
				int curY = red.getY();
				int curX = red.getX();

				// 4방향 탐색
				for (int i = 0; i < 4; i++) {
					int nextY = curY + moveY[i];
					int nextX = curX + moveX[i];

					if (nextX > (M - 1) || nextY > (N - 1) || nextX < 0 || nextY < 0) {
						continue;
					}

					if (board[nextY][nextX] == 1 || board[nextY][nextX] == -1) {
						continue;
					}

					board[nextY][nextX] = 1;
					Position newRedTom = new Position(nextY, nextX);

					queue.add(newRedTom);
				}
			}
			++day;
			/*
			 * // 확인 for (int y = 0; y < N; y++) { for (int x = 0; x < M; x++) {
			 * System.out.print(board[y][x]); } System.out.println(""); }
			 * System.out.println("day "+ day);
			 */
		}
		--day;
		
		//확인
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if(board[y][x] == 0) {
					return -1;
				}
			}
		}
		
		return day;
	}
}

class Position {
	private int y, x;

	Position(int y, int x) {
		this.y = y;
		this.x = x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
