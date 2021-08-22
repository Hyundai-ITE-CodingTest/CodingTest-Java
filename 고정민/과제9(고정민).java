package day0820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuizTwo {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int height_stair = 0; //계단의 높이 
		int total = 0; //총 칼로리 
		int effect= 1; //칼로리 효과 
		int scrap = 0; //급경사의 개수  
		
		for(int i = 0; i<input.length(); i++) {
			if(input.charAt(i)=='#') {
				scrap++;
				if(scrap%2==0) effect = 1;
				else effect=2;
			}
			if(input.charAt(i)=='(') {
				height_stair++;
				total += (height_stair*effect);
			}else if(input.charAt(i)==')') {
				total+= (height_stair*effect);
				height_stair--;
			}
		}
		System.out.println(total);
	}
}
