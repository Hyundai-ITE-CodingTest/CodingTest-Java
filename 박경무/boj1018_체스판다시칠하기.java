package team3.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 첫째 줄에 N과 M이 주어진다. N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수이다. 
 * 50이면 8개짜리 틀을 42개정도 들어감 row col 42 42  최대인 겨웅 1600*64*2 => 1억 안넘음
 * 
 * 완탐으로 좌상단 흑, 백 케이스와 비교 
 * 
 * 
 * 둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다. B는 검은색이며, W는 흰색이다.
 */

public class boj1018_체스판다시칠하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, min =100, cnt_B=0, cnt_W=0;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //y
		M = Integer.parseInt(st.nextToken()); //x
		boolean[][] board = new boolean[M][N];
		for(int i =0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M;j++) {
				if(str.charAt(j)=='B') {
					board[j][i]=true;
				}else {
					board[j][i]=false;
				}
			}		
		}
		//좌상단 좌표 1칸씩 이동
		for (int i = 0; i <= N-8; i++) {
			for (int j = 0; j <= M-8; j++) {
				//좌상단 좌표를 기준으로 8칸씩 조회
				for (int j2 = i; j2 < i+8; j2++) {
					for (int k = j; k < j+8; k++) {
						if((k+j2)%2==1) {
							if(board[k][j2]) {
								//좌상단 b 인경우 홀수인 인덱스는 W가 와야하는데 B가 오면 ++
								cnt_W++;
							}else {
								//좌상단 w
								cnt_B++;
							}
						}
//						(k+j2)==0
						else {
							if(board[k][j2]) {
								//좌상단 w
								cnt_B++;
							}else {
								//좌상단 b
								cnt_W++;
							}
						}
					}
				}//좌표안 다른 좌표 수 cnt 
				min = Math.min(min,cnt_W );
				min = Math.min(min,cnt_B );
				cnt_W=0;
				cnt_B=0;
			}
			
		}
		System.out.println(min);
	}
	

}
