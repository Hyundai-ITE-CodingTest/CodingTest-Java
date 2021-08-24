package baekjoon_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1018 {
	public static boolean[][] board;
	public static int min = 64;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		board = new boolean[n][m];
		
		// 입력받기 W = true, B = false
		for(int i = 0; i < n; i++) {
			String[] temp = bf.readLine().split("");
			for(int j = 0; j < m; j++) {				
				if (temp[j].equals("W")){
					board[i][j] = true;
				} else {
					board[i][j] = false;
				}
			}
		}
		
		// 시작점을 구한다. 0 ~ (n-7) | 0 ~ (m-7)
		// 2중 for문 순회 n, m
		// true일 때 false일 때 두가지 경우
		// count = 0; // 다시 칠해야 하는 정사각형의 개수
		// min(true일 때, false일 때)
		// 반복
		
		for (int i = 0; i < (n-7); i++) {
			for(int j = 0; j < (m-7); j++) {
				find(i, j);
			}
		}
		System.out.println(min);
	}
	public static void find(int x, int y) {
		int end_x = x + 8;
		int end_y = y + 8;
		int count = 0;
		
		boolean tile = board[x][y]; // 시작점
		
		for (int i = x; i < end_x; i++) {
			for (int j = y; j < end_y; j++) {
				
				if (board[i][j] != tile) {
					count++;
				}
				tile = !tile;
			}
			tile = !tile;
		}
		count = Math.min(count, 64 - count);
		
		min = Math.min(min, count);
	}
}
