package codingtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Multiples {

	public static void main(String[] args) throws Exception {
		/** 입력값
			시작수: 1
			끝수: 15
			배수: 7
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int start = Integer.parseInt(br.readLine().split(": ")[1]);
		int end = Integer.parseInt(br.readLine().split(": ")[1]);;
		int multi = Integer.parseInt(br.readLine().split(": ")[1]);;
		
		int sum = 0;
		
		int realstart = ((int) (start / multi) + 1) * multi;
		int realend = ((int)(end/ multi)) * multi + 1;
		
		int i = 1; 
		while(realstart < realend) {
			sum += realstart;
			++i;
			realstart *= i;
		}
		System.out.println(sum);
	}

}
