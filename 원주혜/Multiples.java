package codingtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Multiples {

	public static void main(String[] args) {
		//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int start =1; // 	Integer.parseInt(br.readLine())
		int end = 15; //	Integer.parseInt(br.readLine())
		int multi = 7; // 	Integer.parseInt(br.readLine())
		
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
