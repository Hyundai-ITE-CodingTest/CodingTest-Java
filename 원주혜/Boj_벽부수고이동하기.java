import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[][] board;
	static Integer[][] dist;
	static int[] Y = { -1, 1, 0, 0 };
	static int[] X = { 0, 0, -1, 1 };
	static int N, M;
	
	static Integer[][] distDestroyed;
	static Integer[][] distNotDestroyed;


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		board = new int[N + 1][M + 1];
		distDestroyed = new Integer[N + 1][M + 1];
		distNotDestroyed = new Integer[N + 1][M + 1];

		// board 그리기
		for (int y = 0; y < N; y++) {
			int[] line = Arrays.asList((br.readLine()).split("")).stream().mapToInt(Integer::parseInt).toArray();
			for (int x = 0; x < M; x++) {
				board[y + 1][x + 1] = line[x];
			}
		}
		
		bfs();
		int result = Integer.MAX_VALUE;
		if(distDestroyed[N][M] != null) {
			if(result > distDestroyed[N][M]) {
				result = distDestroyed[N][M];
			}
		}else if(distNotDestroyed[N][M] != null) {
			if(result > distNotDestroyed[N][M]) {
				result = distNotDestroyed[N][M];
			}
		}else {
			result = -1;
		}
		System.out.print(result);
	}

	static void bfs() {
		Queue<Block> que = new LinkedList<Block>();
		distDestroyed[1][1] = 1;
		distNotDestroyed[1][1] = 1;
		
		que.add(new Block(1, 1, false));

		while (!que.isEmpty()) {
			Block here = que.poll();
			// 상하좌우 인접
			for (int i = 0; i < 4; i++) {
				int nextY = here.y + Y[i];
				int nextX = here.x + X[i];

				// 이동하지 못하는 경우
				if (nextY < 1 || nextY > N || nextX < 1 || nextX > M) {
					continue;
				}
				
                // 이미 방문한 경우
				if(here.isDestroyed) {
					if (distDestroyed[nextY][nextX] != null) {
						continue;
					}
				}else {
					if (distNotDestroyed[nextY][nextX] != null) {
						continue;
					}
				}
				
				// 벽에 막혀있을 경우
				if (board[nextY][nextX] == 1) {
					if (here.isDestroyed) {
						continue;
					}
					distDestroyed[nextY][nextX] = distNotDestroyed[here.y][here.x] + 1;
					que.add(new Block(nextY, nextX, true));
					continue;
				}
                
				// 통과 가능한 경우
				if(here.isDestroyed) {
					distDestroyed[nextY][nextX] = distDestroyed[here.y][here.x] + 1;
					que.add(new Block(nextY, nextX, true));
				}else {
					distNotDestroyed[nextY][nextX] = distNotDestroyed[here.y][here.x] + 1;
					que.add(new Block(nextY, nextX, false));
				}
			}
		}
	}
}

class Block {
	int y, x;
	boolean isDestroyed;

	Block(int y, int x, boolean isDestroyed) {
		this.y = y;
		this.x = x;
		this.isDestroyed = isDestroyed;
	}
}
