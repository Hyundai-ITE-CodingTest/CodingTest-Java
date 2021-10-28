package team3.day3;

import java.io.*;
import java.util.*;
public class boj2206벽부수고이동하기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
	static StringBuilder sb = new StringBuilder();
	static int[][] board;
	static boolean[][][] visited;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int X,Y;
	public static void main(String[] args) throws IOException {
		String[] arr = br.readLine().split(" ");
		Y=Integer.parseInt(arr[0]);
		X=Integer.parseInt(arr[1]);
		board = new int[X][Y];
		visited= new boolean[X][Y][2];
		for(int i=0; i<Y; i++) {
			String str = br.readLine();
			for(int j=0; j<X; j++) {
				if(str.charAt(j)=='0') {
					visited[j][i][0]=false;
					visited[j][i][1]=false;
				}else {
					visited[j][i][0]=true;
					visited[j][i][1]=true;
					board[j][i]=1;
				}
			}
		}
		
		bfs(new Point5(0,0,0,false));
		
		
	}
	static void bfs(Point5 p) {
		visited[p.x][p.y][0]=true;
		Queue<Point5> q = new LinkedList<Point5>();
		q.add(p);
		while(!q.isEmpty()) {
			Point5 now = q.poll();
			int x = now.x;
			int y = now.y;
			int cnt= now.cnt;
			boolean breakWall= now.breakWall;
//			System.out.println("------------");
//			System.out.print("x: "+x);
//			System.out.print(" y: "+y);
//			System.out.println(" breakWall: " +breakWall);
			
			if(x==(X-1) &&y==(Y-1)) {
				System.out.println(cnt+1);
				return;
			}
			for (int i = 0; i < dx.length; i++) {
				int nx =x+dx[i];
				int ny =y+dy[i];
				int ncnt = cnt+1;
				boolean nbreakWall =breakWall;
				
//				System.out.println("------------");
//				System.out.print("nx: "+nx);
//				System.out.print(" ny: "+ny);
//				System.out.println(" nbreakWall: " +nbreakWall);
				
				if(nx>=X ||ny>=Y||nx<0||ny<0) {
					continue;
				}
				//벽을 부순 이력이 있는경우
				if(nbreakWall) {
					//벽이나오면 무조건 돌려보내기
					if(visited[nx][ny][1]) {
						continue;
					}
					//벽이 아니면 방문처리 후 q 넣기
					visited[nx][ny][1]=true;
					q.add(new Point5(nx,ny,ncnt,nbreakWall));
				}
				//벽을 부순 이력이 없는 경우
				else {
					//벽을 만나면 부수고 그 자리로 이동한다
					if(visited[nx][ny][0]) {
						visited[nx][ny][1]=true;
						q.add(new Point5(nx,ny,ncnt,true));
					}else {
						visited[nx][ny][0]=true;
						q.add(new Point5(nx,ny,ncnt,nbreakWall));
					}
				}
				
		
				
			}
			
		}
		System.out.println("-1");
		return;
		
		
	}

}
class Point5 {
	int x;
	int y;
	int cnt;
	//false 면 아직 벽은 안부순거
	boolean breakWall;
	
	Point5(int x, int y, int cnt, boolean breakWall){
		this.x=x;
		this.y=y;
		this.cnt=cnt;
		this.breakWall=breakWall;
	}
}
/*
8 8
01000100
01010100
01010100
01010100
01010100
01010100
01010100
00010100
*/