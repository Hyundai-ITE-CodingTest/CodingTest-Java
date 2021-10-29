import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int[][] board;
	static Point[][] parents;
	static Integer[][] distance;
	static int srcY, srcX;
	static int dstY, dstX;
	static int MIN = Integer.MAX_VALUE;
	static int[] X = { -2, -2, -1, -1, 2, 2, 1, 1 };
	static int[] Y = { -1, 1, -2, 2, -1, 1, -2, 2 };
	static int I;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			I = Integer.parseInt(br.readLine());
			board = new int[I][I];
			parents = new Point[I][I];
			distance = new Integer[I][I];

			String[] srcs = br.readLine().split(" ");
			srcY = Integer.parseInt(srcs[0]);
			srcX = Integer.parseInt(srcs[1]);
			String[] dests = br.readLine().split(" ");
			dstY = Integer.parseInt(dests[0]);
			dstX = Integer.parseInt(dests[1]);

			bfs(srcY, srcX);
			sb.append(distance[dstY][dstX] + "\n");
		}
		System.out.print(sb);

	}

	static void bfs(int startY, int startX) {
		Queue<Point> que = new LinkedList<Point>();
		Point start = new Point(startY, startX);
		parents[startY][startX] = start;
		distance[startY][startX] = 0;

		que.add(start);

		while (!que.isEmpty()) {
			Point here = que.poll();

			// 나이트가 이동할 수 있는 정점 계산
			for(int i=0; i < 8; i++) {
				Point next = new Point(here.y + Y[i], here.x + X[i]);
				
				if(next.y < 0 || next.y  >= I
						|| next.x < 0 || next.x >= I) {
					continue;
				}
				
				if(distance[next.y][next.x] == null) {
					//System.out.println("발견 " + next.y + " " + next.x);
					que.add(next);
					distance[next.y][next.x] = distance[here.y][here.x] + 1;
					parents[next.y][next.x] = here;
				}				
			}
		}
	}
}

class Point {
	int y, x;

	Point(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
