package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_달팽이 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int[][] board ;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int val = Integer.parseInt(br.readLine());
		board = new int[N][N];
		int x=N/2;
		int y=N/2;
		int cnt=1;
		int Num=1;
		int solx = 0,soly=0;
		board[x][y]=1;
		loop1:
		while(true) {
			
				//위로
				for (int j = 0; j < Num; j++) {
					y--;
					cnt++;
					if(x<0 || y<0 || y>=N|| x>=N) {
						break loop1;
					}
					board[x][y]=cnt;
					if(cnt==val) {
						solx=x;
						soly=y;
					}
				}
				//오른쪽으로
				for (int j = 0; j < Num; j++) {
					x++;
					cnt++;
					if(x<0 || y<0 || y>=N|| x>=N) {
						break loop1;
					}
					board[x][y]=cnt;
					if(cnt==val) {
						solx=x;
						soly=y;
					}
				}
				Num++;

				//아래로
				for (int j = 0; j < Num; j++) {
					y++;
					cnt++;
					if(x<0 || y<0 || y>=N|| x>=N) {
						break loop1;
					}
					board[x][y]=cnt;
					if(cnt==val) {
						solx=x;
						soly=y;
					}
				}
				//왼쪽으로
				for (int j = 0; j < Num; j++) {
					x--;
					cnt++;
					if(x<0 || y<0 || y>=N|| x>=N) {
						break loop1;
					}
					board[x][y]=cnt;
					if(cnt==val) {
						solx=x;
						soly=y;
					}
				}
				Num++;
			
		}
		if(val==1) {
			solx=N/2;
			soly=N/2;
		}
		
		for (int i = 0; i <N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(board[j][i]).append(" ");
			}
			sb.append("\n");
		}
		sb.append(soly+1).append(" ").append(solx+1);
		System.out.println(sb);
		
		
	}

}
