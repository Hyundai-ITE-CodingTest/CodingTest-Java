package codingtest;

import java.util.*;

public class 체스판다시칠하기_1018_변용혁 {
	static String[] board;
	static int N;
	static int M;	
	static char[] BW = {'B','W'};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		
		board = new String[N];
		for(int i=0; i<N; i++) {
			board[i] = sc.nextLine();
		}
		System.out.println(Solution());
	}
	public static int Solution() {
		int min = Integer.MAX_VALUE;
		
		int idx = 0; //검은색 시작
		for(int i=0; i<=N-8; i++) {
			for(int j=0; j<=M-8; j++) {
				int cnt = 0;
				for(int y=0; y<8; y++) {
					for(int x=0; x<8; x++) {
						if(board[i+y].charAt(j+x) != BW[idx % 2]) {
							cnt++;
						}
						idx++;
					}
					idx--;
				}
				if(min > cnt)
					min = cnt;
			}
		}
		idx = 1; //흰색 시작
		for(int i=0; i<=N-8; i++) {
			for(int j=0; j<=M-8; j++) {
				int cnt = 0;
				for(int y=0; y<8; y++) {
					for(int x=0; x<8; x++) {
						if(board[i+y].charAt(j+x) != BW[idx % 2]) {
							cnt++;
						}
						idx++;
					}
					idx--;
				}
				if(min > cnt)
					min = cnt;
			}
		}
		return min;
	}
}
