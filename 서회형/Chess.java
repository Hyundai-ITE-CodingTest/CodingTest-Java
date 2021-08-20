package CodingTest8_19;

import java.util.Scanner;

public class Chess {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		int M = input.nextInt();
		int minNum = 64; //최고 64를 다 칠해야하는경우가 있음 
		//하얀색으로 시작하는 체스 원본
		char[][] WhiteChess= 
			{{'W','B','W','B','W','B','W','B'}
			,{'B','W','B','W','B','W','B','W'}
			,{'W','B','W','B','W','B','W','B'}
			,{'B','W','B','W','B','W','B','W'}
			,{'W','B','W','B','W','B','W','B'}
			,{'B','W','B','W','B','W','B','W'}
			,{'W','B','W','B','W','B','W','B'}
			,{'B','W','B','W','B','W','B','W'}
		}; 
		//검은색으로 시작하는 체스 원본
		char[][] BlackChess= 
			{{'B','W','B','W','B','W','B','W'}
			,{'W','B','W','B','W','B','W','B'}
			,{'B','W','B','W','B','W','B','W'}
			,{'W','B','W','B','W','B','W','B'}
			,{'B','W','B','W','B','W','B','W'}
			,{'W','B','W','B','W','B','W','B'}
			,{'B','W','B','W','B','W','B','W'}
			,{'W','B','W','B','W','B','W','B'}
		}; 
		
		String[] chessInput = new String[N]; //입력받은 원본 체스판
		char[][] chessStore = new char[N][M]; //저장하는 곳
		char[][] newChess = new char[8][8];
		for(int i = 0; i < N; i++) {
			
				chessInput[i] = input.next();
			
		}
		for(int i = 0; i < N; i ++) {
			for(int j = 0 ; j < M; j++) {
				chessStore[i][j] = chessInput[i].charAt(j);
			}
		}
		//임의의 체스판 1개 생성 다음 체스판을 만들때는 어디를 건드려야 하는것인가??
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				newChess[i][j] = chessStore[i][j]; 
			}
		}
		int Wcount = 0;
		int Bcount = 0;
		
		for(int i = 0; i <8; i++) {
			for(int j = 0; j < 8; j++) {
				if(WhiteChess[i][j] != newChess[i][j]) {
					Wcount++;
				}
				if(BlackChess[i][j] != newChess[i][j]) {
					Bcount++;
				}
			}	
		}
		minNum = Math.min(Wcount, Bcount);
		System.out.println(minNum);

	}

}
