package day14_Quiz;

import java.util.Scanner;

public class Quiz1 {
	public static void main(String[] args) {
		System.out.println("Hello MyCompany!를 몇번 출력하시겠습니까?");
		int n = new Scanner(System.in).nextInt();
		for(int i = 0; i < n; i++) {
			System.out.println("Hello MyCompany!");
		}
	}
}
