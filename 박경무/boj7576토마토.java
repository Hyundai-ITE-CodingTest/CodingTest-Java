package team3.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj7576토마토 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N ,M, max=0;
	static int[][] board;
	static boolean[][] visited;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static Queue<Tom> q = new LinkedList<Tom>();
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());//x
		N = Integer.parseInt(st.nextToken());//y
		board = new int[M][N];
		visited = new boolean[M][N];
		//board 초기값 넣어주기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[j][i]=Integer.parseInt(st.nextToken());
			}
		}
		//q에 넣어주기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(board[j][i]==1) {
					visited[j][i]=true;
					q.add(new Tom(j,i,0));
				}
			}
		}
		//bfs 로 q 돌면서 토마토 익히기
		bfs();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(board[j][i]==-0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(max);
		
	}
	static void bfs() {
	
		
		while(!q.isEmpty()) {
			Tom tom = q.poll();
			int x = tom.x;
			int y = tom.y;
			int day = tom.day;
			
			for (int i = 0; i < dx.length; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				int nday = day+1;
				
				if(nx>=M || ny >=N || nx<0 ||ny <0) {
					continue;
				}
				if(visited[nx][ny] || board[nx][ny]==-1) {
					continue;
				}
				visited[nx][ny]=true;
				board[nx][ny]=1;
				q.add(new Tom(nx,ny,nday));
				max=Math.max(max, nday);
			}
			
		}
	}

}
class Tom{
	int x;
	int y;
	int day;
	Tom(int x, int y, int day){
		this.x= x;
		this.y= y;
		this.day= day;
	}
}