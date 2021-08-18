package codingtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Stars {

	public static void main(String[] args) {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = 5; //Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < input; i++) {
			for(int j=0; j < i+1; j++) {
				sb.append('*');
			}
			sb.append('\n');
		}
		
		for(int i=input; i >0 ; i--) {
			for(int j=0; j < i; j++) {
				sb.append('*');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

}
