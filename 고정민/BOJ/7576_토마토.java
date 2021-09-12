import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int m;
	static int n;
	static int[][] box;
	static int[] dx = {-1, 1, 0, 0}; //상하좌우 
	static int[] dy = {0, 0, -1, 1};
	
	static class Tomato{
		int x;
		int y;
		int day;
		
		public Tomato(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		box = new int[n][m];
		
		//box 입력받기
		for(int i = 0 ; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<m; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
	}
	
	public static void bfs() {
		Queue<Tomato> queue = new LinkedList<Tomato>();
		int day = 0;
		
		//박스에서 익은 토마토들만 큐에 넣기
		for(int i = 0; i<n; i++) {
			for(int j = 0 ; j<m; j++) {
				if(box[i][j] == 1) {
					queue.offer(new Tomato(i, j, 0));
				}
			}
		}
		//익히기
		while(!queue.isEmpty()) {
			Tomato t = queue.poll();
			day = t.day;
			
			//상하좌우 탐색
			for(int i=0; i<4; i++) {
				int nx = t.x + dx[i];
				int ny = t.y + dy[i];
				
				if(nx>=0 && nx<n && ny>=0 && ny<m) {
					if(box[nx][ny]== 0) {
						box[nx][ny] = 1;
						queue.add(new Tomato(nx, ny, day+1));
					}
				}
			}
		}
		if(check())	System.out.print(day);
		else System.out.print(-1);
		
	}
	static boolean check() {
		for(int i = 0 ; i<n; i++) {
			for(int j = 0 ; j<m; j++) {
				if(box[i][j] == 0)	return false;
			}
		}
		return true;
	}
	
}
