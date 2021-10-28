package team3.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj나이트의이동 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static boolean visited[][];
	static int board[][];
	static int SIZE;
	static int X, Y;
	static int[] dx = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] dy = { 1, -1, 2, -2, 2, -2, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			SIZE = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split(" ");
//			visited=null;
//			board=null;
			board = new int[SIZE][SIZE];
			visited = new boolean[SIZE][SIZE];
			String[] arr2 = br.readLine().split(" ");
			X = Integer.parseInt(arr2[0]);
			Y = Integer.parseInt(arr2[1]);
//			System.out.println("x y SIZE"+" "+X+" "+Y+" "+SIZE);

			bfs(new Point3(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), 0));

		}
		System.out.print(sb);

	}

	static void bfs(Point3 p) {
		if (p.x == X && p.y == Y) {
			sb.append(p.cnt).append("\n");
			return;
		}
		
		visited[p.x][p.y] = true;

		Queue<Point3> q = new LinkedList<Point3>();
		q.add(p);

		Loop1: while (!q.isEmpty()) {
			Point3 now = q.poll();

			int x = now.x;
			int y = now.y;
			int cnt = now.cnt;
//			System.out.print("x y cnt"+" "+x+" "+y+" "+cnt);
			

			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int ncnt = cnt + 1;

				if (nx >= SIZE || ny >= SIZE || nx < 0 || ny < 0 || visited[nx][ny]) {
					continue;
				}
				if (nx == X && ny == Y) {
					sb.append(ncnt).append("\n");
					break Loop1;
				}
				visited[nx][ny] = true;
				q.add(new Point3(nx, ny, ncnt));

			}
		}

	}

}

class Point3 {
	int x;
	int y;
	int cnt;

	Point3(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}
