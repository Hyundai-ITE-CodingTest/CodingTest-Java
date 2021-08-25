package codingtest;

import java.util.*;

public class 덩치_변용혁_7568 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] memb = new int[N][2];
		int[] answer = new int[N];
		
		for(int i=0; i<N; i++) {
			memb[i][0] = sc.nextInt();
			memb[i][1] = sc.nextInt();
		}
		
		for(int i=0; i<N; i++) {
			int up = 0;
			for(int j=0; j<N; j++) {
				if(i == j) continue;
				if(memb[i][0] < memb[j][0] && memb[i][1] < memb[j][1]) 
					up++; //키 몸무게 나보다 큰사람 수 up에 저장
			}
			answer[i] = up+1; //큰사람 수 +1 = 내 등수
		}
		
		for(int i=0; i<N; i++) {
			System.out.print(answer[i] + " ");
		}
	}
}
