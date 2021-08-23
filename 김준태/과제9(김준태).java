package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quiz_02 {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("등고선 입력 : ");
		String contour = bf.readLine();
		// ((#(())#(())))
		
		// 1 2 6 8 8 6 3 4 4 3 2 1
		boolean status = false;
		int slope = 1;
		int height = 0;
		int answer = 0;
		for (int i = 0; i < contour.length(); i++) {
			switch(contour.charAt(i)) {
				case '#':
					status = !status;
					if (status) {
						slope = 2;
					}else {
						slope = 1;
					}
					break;
				case '(':
					++height;
					answer += height * slope;
					break;
				case ')':
					answer += height * slope;
					height--;
					break;
			}
			
		}
		System.out.println(answer);
	}
}
