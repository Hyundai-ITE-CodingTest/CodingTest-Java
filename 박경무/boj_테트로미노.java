package 구현;

import java.util.*;
import java.io.*;

public class boj_테트로미노 {
	// 아이디어 -> 판때기 회전
	// -> 한판당 4개의 도형 4개도형을 돌린다 즉
	// 판1개 -> 2중반복문 -> 한점 구해짐 -> 그 점을 좌상단에서 우하단으로 이동시키면서 최소값 연산
	// 그 점을 시작으로 모양대로 이동하고 이동하다가 중간에 뭐가 걸리면 그 값 폐기
	static int N, M;
	static int[][] board1;
	static int[][] board2;
	static int[][] board3;
	static int[][] board4;
	static int MAX = -10;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		String[] arr1 = br.readLine().split(" ");
		N = Integer.parseInt(arr1[0]); // 세로
		M = Integer.parseInt(arr1[1]);
		// 보드4개 생성
		board1 = new int[M][N];
		board2 = new int[N][M];
		board3 = new int[M][N];
		board4 = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] arr2 = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				board1[j][i] = Integer.parseInt(arr2[j]);
			}
		}
		// 90도 회전

		for (int i = 0; i < M; i++) {

			for (int j = 0; j < N; j++) {
				board2[j][i] = board1[i][N - 1 - j];
//				System.out.print(board2[j][i] + " ");
			}
//			System.out.println(" ");
		}
		// 90도 회전
 		for (int i = 0; i < N; i++) {

			for (int j = 0; j < M; j++) {
				board3[j][i] = board1[M-1-j][N-1-i];
//				System.out.print(board3[j][i] + " ");
			}
//			System.out.println(" ");
		}
		
 		//이전 회전 값을 활용해서 회전가능
		for (int i = 0; i < M; i++) {

			for (int j = 0; j < N; j++) {
				board4[j][i] = board3[i][N - 1 - j];
//				System.out.print(board4[j][i] + " ");
			}
//			System.out.println(" ");
		}
		
		/////////////////////
		for (int i = 0; i < M; i++) {
			
			for (int j = 0; j < N; j++) {
				//일자 블럭
				if(i+3<M) {
					MAX =Math.max(MAX,(board2[j][i]+board2[j][i+1]+board2[j][i+2]+board2[j][i+3]));
					MAX =Math.max(MAX,(board4[j][i]+board4[j][i+1]+board4[j][i+2]+board4[j][i+3]));
//					System.out.println(board2[j][i]+board2[j][i+1]+board2[j][i+2]+board2[j][i+3]);
				}
			
				//정사각 블럭
				if(j+1<N && i+1<M) {
					MAX =Math.max(MAX,board2[j][i]+board2[j+1][i]+board2[j][i+1]+board2[j+1][i+1]);
					MAX =Math.max(MAX,board4[j][i]+board4[j+1][i]+board4[j][i+1]+board4[j+1][i+1]);
				}
				//니은 블럭 뒤집어진 것 	//번개블럭 뒤집어 진 것
				if(j<N && i+2<M&& j>=1) {
					//니은 뒤집은
					MAX =Math.max(MAX,board2[j][i]+board2[j][i+1]+board2[j][i+2]+board2[j-1][i+2]);
					MAX =	Math.max(MAX,board4[j][i]+board4[j][i+1]+board4[j][i+2]+board4[j-1][i+2]);
					//번개 뒤집은
					MAX =Math.max(MAX,board2[j][i]+board2[j][i+1]+board2[j-1][i+1]+board2[j-1][i+2]);
					MAX =Math.max(MAX,board4[j][i]+board4[j][i+1]+board4[j-1][i+1]+board4[j-1][i+2]);
				}
			
//				if()
				//뻐큐 블럭
				if(j+2<N && i+1<M) {
					MAX =Math.max(MAX,board2[j][i]+board2[j+1][i]+board2[j+1][i+1]+board2[j+2][i]);
					MAX =Math.max(MAX,board4[j][i]+board4[j+1][i]+board4[j+1][i+1]+board4[j+2][i]);
				}
				//번개 블럭+ 니은 블럭
				if(j+1<N && i+2<M) {
//					번개
					MAX =Math.max(MAX,board2[j][i]+board2[j][i+1]+board2[j+1][i+1]+board2[j+1][i+2]);
					MAX =Math.max(MAX,board4[j][i]+board4[j][i+1]+board4[j+1][i+1]+board4[j+1][i+2]);
//					니은
					MAX =Math.max(MAX,board2[j][i]+board2[j+1][i+2]+board2[j][i+1]+board2[j][i+2]);
					MAX =Math.max(MAX,board4[j][i]+board4[j+1][i+2]+board4[j][i+1]+board4[j][i+2]);
				}
//				board2[][];
			}
		}
		
		for (int i = 0; i < N; i++) {
			
			for (int j = 0; j < M; j++) {
				//일자 블럭
				if(i+3<N) {
					MAX =	Math.max(MAX,board1[j][i]+board1[j][i+1]+board1[j][i+2]+board1[j][i+3]);
					MAX =Math.max(MAX,board3[j][i]+board3[j][i+1]+board3[j][i+2]+board3[j][i+3]);
				}
				//정사각 블럭
				if(j+1<M && i+1<N) {
					MAX =	Math.max(MAX,board1[j][i]+board1[j+1][i]+board1[j][i+1]+board1[j+1][i+1]);
					MAX =	Math.max(MAX,board3[j][i]+board3[j+1][i]+board3[j][i+1]+board3[j+1][i+1]);
				}
				//니은 블럭 대칭 빼먹음
				if(j+1<M && i+2<N) {
					MAX =	Math.max(MAX,board1[j][i]+board1[j+1][i+2]+board1[j][i+1]+board1[j][i+2]);
					MAX =	Math.max(MAX,board3[j][i]+board3[j+1][i+2]+board3[j][i+1]+board3[j][i+2]);
				}
				
				//니은 블럭 뒤집어진 것 	//번개블럭 뒤집어 진 것
				if(j<M && i+2<N&& j>=1) {
					//니은 뒤집은
					MAX =	Math.max(MAX,board1[j][i]+board1[j][i+1]+board1[j][i+2]+board1[j-1][i+2]);
					MAX =Math.max(MAX,board3[j][i]+board3[j][i+1]+board3[j][i+2]+board3[j-1][i+2]);
					//번개 뒤집은
					MAX =	Math.max(MAX,board1[j][i]+board1[j][i+1]+board1[j-1][i+1]+board1[j-1][i+2]);
					MAX =	Math.max(MAX,board3[j][i]+board3[j][i+1]+board3[j-1][i+1]+board3[j-1][i+2]);
				}
				
				
				//뻐큐 블럭
				if(j+2<M && i+1<N) {
					MAX =	Math.max(MAX,board1[j][i]+board1[j+1][i]+board1[j+1][i+1]+board1[j+2][i]);
					MAX =	Math.max(MAX,board3[j][i]+board3[j+1][i]+board3[j+1][i+1]+board3[j+2][i]);
				}
				//번개 블럭 대칭 빼먹음
				if(j+1<M && i+2<N) {
					MAX =	Math.max(MAX,board1[j][i]+board1[j][i+1]+board1[j+1][i+1]+board1[j+1][i+2]);
					MAX =	Math.max(MAX,board3[j][i]+board3[j][i+1]+board3[j+1][i+1]+board3[j+1][i+2]);
				}
			}
		}
		System.out.print(MAX);
		
		
		

	}

}
