package week07;

import java.awt.Point;
import java.io.*;
import java.util.*;

public class 토마토_7576 {

	static int[][] arr;
	static int green = 0; // 안익은 토마토 갯수
	static int max = 0; //다 익히는 횟수
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		Queue<Point> que = new LinkedList<Point>();

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < M; c++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 0)
					green++;
				if (temp == 1)
					que.add(new Point(c, r)); // 시작 토마토
				arr[r][c] = temp -1;
			}
		}

		while(que.size() > 0) {
			Point cur = que.poll();
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				if (0 <= nx && nx < M && 0 <= ny && ny < N && arr[ny][nx] == -1) { // 범위에 들고 안익은 토마토면
					if(arr[ny][nx] == -2) continue; //토마토 없는곳 패스
					arr[ny][nx] = arr[cur.y][cur.x] + 1; //익히는 횟수 증가
					max = arr[ny][nx]; //최대 횟수 저장
					que.add(new Point(nx, ny));
					green--; //토마토 익음
				}
			}
		}

		if(green == 0) 
			System.out.println(max);
		else {//안익은 토마토가 남았으면 -1
			System.out.println("-1");
		}
	}
}
