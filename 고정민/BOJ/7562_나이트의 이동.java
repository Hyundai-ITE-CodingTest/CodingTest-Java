import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int T; //테스트케이스 개수 
	static int l; //체스판 한 변의 길이
	static int startx, starty;
	static int endx, endy;
	static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dy = {-2, -1, 1, 2, -2, -1, 1, 2};
	static boolean[][] visited;
	static int ans = 0;
	
	static class Pos {
		int x;
		int y;
		int count;
		
		public Pos(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			l = Integer.parseInt(br.readLine());
			visited = new boolean[l][l];
			
			String[] start = br.readLine().split(" ");
			String[] end = br.readLine().split(" ");

			startx = Integer.parseInt(start[0]);
			starty = Integer.parseInt(start[1]);
			
			endx = Integer.parseInt(end[0]);
			endy = Integer.parseInt(end[1]);
			
			bfs(new Pos(startx, starty, 0));
			System.out.println(ans);
		}
	}
	
	static void bfs(Pos pos) {
		
		Queue<Pos> q = new LinkedList<>();
		visited[pos.x][pos.y] = true;
		q.add(pos);

		while(!q.isEmpty()) {
			Pos p = q.poll();
			//종료조건
			if(p.x ==endx && p.y == endy) {
				ans = p.count;
				break;
			}
			
			for(int i =0; i<8; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				int cnt = p.count + 1;
				
				if(nx >= 0 && nx < l && ny>=0 && ny<l && !visited[nx][ny]) {
					q.add(new Pos(nx, ny, cnt));
					visited[nx][ny] = true;
				}
			}
		}
	}
}
