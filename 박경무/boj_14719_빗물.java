package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_14719_빗물 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	// 500*500 = 250000 2중for 가능
	// 맵입력받기 1은 벽 0은 빈공간
	// 좌상단 부터 스캔
	// 스캔 중 최초로 1 나오면 그 줄에 다른 1 있는지 확인
	// 1있으면 둘의 인덱스 -1 만큼 물 들어갈 수 있음 (그만큼 cnt+)그리고 다른 1을 다시 최초 1 자리에 넣고 다음 1이 나오는지 과정
	// 반복
	// 1 다시 안나오면 그냥 끝냄

	public static void main(String[] args) throws IOException {
		String[] arr = br.readLine().split(" ");
		int Y = Integer.parseInt(arr[0]);
		int X = Integer.parseInt(arr[1]);
		int[][] board = new int[X][Y];
		String[] arr2 = br.readLine().split(" ");

		for (int i = 0; i < X; i++) {
			for (int j = 0; j < Integer.parseInt(arr2[i]); j++) {
				board[i][Y - 1 - j] = 1;
			}
		}
		
		int cnt=0;
		for (int i = 0; i < Y; i++) {
			int first=-1;
			int second=-1;
			boolean isFindFirst = false;
//			boolean isFindSecond = false;
			for (int j = 0; j < X; j++) {
				if(board[j][i]==1) {
					//아예 처음 발견하는 경우
					if(!isFindFirst) {
						first = j;
						isFindFirst= true;
						continue;
					}else {
						second =j;
						cnt += (second-first-1);
						first =j;
					}
				}
			}
		}
		System.out.println(cnt);
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				System.out.print(board[j][i]+" ");
			}
			System.out.println(" ");
		}
	}

}
