package CodingReady;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class 피보나치_1003 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//테스트 케이스 갯수
		Integer T = Integer.parseInt(br.readLine());
		
		//0의 개수와 1의 개수를 저장할 배열
		int[][] store = new int[2][41];
		store[0][0] = 1;
		store[1][0] = 0;
		store[0][1] = 0;
		store[1][1] = 1;
		for(int i = 2; i < 41; i++) {
			store[1][i] = store[1][i-1] + store[1][i-2];
			store[0][i] = store[1][i-1];
		}
		for(int i = 0; i < T; i++) {
			Integer X = Integer.parseInt(br.readLine());
			bw.write(store[0][X] + " " + store[1][X]);  
			bw.newLine();
		}
		
		 	bw.flush();
			bw.close();
			br.close();
		
		
	}
	//시간 초과가 된다. 동적계획이 아니라 완전탐색처럼 되어서 그런가?
	public static int fibo(int n, int what) {
		int countZero = 0;
		int countOne = 0;
		if(n == 0) {
			if(what == 0) {
				countZero++;
				return countZero;
			}
			else {
				return 0;
			}
		}
		else if( n == 1) {
			if(what == 1) {
				countOne++;
				return countOne;
			}
			else {
				return 0;
			}
			
		}
		else {
			 return fibo(n-1,what) +  fibo(n-2,what);
		}
	}
		
}
