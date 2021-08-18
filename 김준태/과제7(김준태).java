package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quiz_03 {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		int num = Integer.parseInt(bf.readLine());
		String[] scores = bf.readLine().split(" ");
		String firstBlock = bf.readLine();
		String secondBlock = bf.readLine();
		
		for (int i = 0; i < num; i++) {
			if(firstBlock.charAt(i) == 'O' && secondBlock.charAt(i) == 'O') {
				sum += Integer.parseInt(scores[i]);
			}
		}
		System.out.println(sum);
	}
}
