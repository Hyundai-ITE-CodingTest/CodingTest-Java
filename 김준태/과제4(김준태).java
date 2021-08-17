package day14_Quiz;

import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		System.out.print("암호를 입력해주세요 : ");
		
		String input = new Scanner(System.in).next();
		System.out.println(input.toCharArray());
		
		for (int i = 0; i < input.length(); i++) {
			int temp = (input.charAt(i)+4);
			if (temp > 122) {
				temp -= 26;
			}
			char answer = (char)temp;
			System.out.print(answer);
		}
	}
}
