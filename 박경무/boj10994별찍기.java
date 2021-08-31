package team3.day3;

import java.util.Scanner;

public class boj10994별찍기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int max = ((n - 1) * 4) + 1;
		boolean[][] map = new boolean[max][max];
		int mid = max / 2;
		int x = mid, y = mid;
		map[x][y] = true;
		for (int i = 1; i < n; i++) {
			x = mid; y = mid;
			x-=i*2;
			y -= i * 2;
			// 시계방향으로 (i*4)+1만큼 한바퀴 돌기
			for (int j = 0; j < (i * 4) ; j++) {
				map[x][y] = true;
				x++;
			}
			for (int j = 0; j < (i * 4) ; j++) {
				map[x][y] = true;
				y++;
			}
			for (int j = 0; j < (i * 4)  ; j++) {
				
				map[x][y] = true;
				x--;
			}
			for (int j = 0; j < (i * 4) ; j++) {
			
				map[x][y] = true;
				y--;
			}
			 
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[j][i]) {
					sb.append("*");
				}else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
