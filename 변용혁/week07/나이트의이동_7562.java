package week07;

import java.awt.Point;
import java.io.*;
import java.util.*;

public class 나이트의이동_7562 {
	static int[] dx = { 2, 2, 1, 1, -1, -1, -2, -2 };
	static int[] dy = { 1, -1, 2, -2, 2, -2, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int x ,y ;
		for (int i = 0; i < T; i++) {
			int I = Integer.parseInt(br.readLine());
			boolean[][] visit = new boolean[I][I];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());	
			Point src = new Point(x, y);

			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());	
			
			Point dst = new Point(x, y);

			bw.write(String.valueOf(BFS(src, dst, I, visit)));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

	public static int BFS(Point src, Point dst, int I, boolean[][] visit) {
		
		if(src.equals(dst)) return 0;
		
		int answer = 0;
		HashSet<Point> Aque = new HashSet<Point>(); //중복제거 (set)
		List<Point> Bque;
		Aque.add(src);
		visit[src.y][src.x] = true;
		
		while (Aque.size() > 0) {
			
			Bque = new ArrayList<Point>();// 새로운 큐 생성
			Bque.addAll(Aque);// 새로운 큐에 원래 있던값 다 복사
			Aque.clear(); // 원래 큐 비우기
			
			while (Bque.size() > 0) {// 갈수 있는경우 새로운 큐에 다넣기
				Point p = Bque.remove(0);
				for (int d = 0; d < 8; d++) {
					int nx = p.x + dx[d];
					int ny = p.y + dy[d];
					//67번째 줄에서 찾는게 아닌 add 해줄때 dst를 찾으니까 오히려 시간 증가
					if (0 <= nx && nx < I && 0 <= ny && ny < I && !visit[ny][nx]) {
						Aque.add(new Point(nx, ny));
						visit[ny][nx] = true;  // 시간초과 - visit로 해결
					}
				}
			}
			answer += 1;
			if(Aque.contains(dst)) {
				return answer;
			}
			Aque.addAll(Bque);// 새로운큐에 있는내용 원래큐에 복사
		}

		return answer;
	}
}
