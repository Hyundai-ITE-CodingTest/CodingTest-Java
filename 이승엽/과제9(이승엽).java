package day03;

import java.util.Scanner;

public class no2 {

	public static void main(String[] args) {
		String str = new Scanner(System.in).nextLine();
		int sum = 0;
		int height = 0;
		boolean sharp = false;
		
		for(int i = 0; i < str.length();i++) {
			if(str.charAt(i) == '(') {
				height++;
				if(sharp) {
					sum += height*2;
				}else {
					sum += height;
				}
			}else if(str.charAt(i) == ')') {
				if(sharp) {
					sum += height*2;
				}else {
					sum += height;
				}
				height--;
			}else {
				sharp = !sharp;
			}
		}
		
		System.out.println(sum);

	}

}
