package day14_Quiz;

import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		int[] answer = new int[10];
		int result = 1;
		
		System.out.print("정수,정수,정수 형식으로 입력해주세요 : ");
		String input = new Scanner(System.in).next();
        String[] numbers = input.split(",");
        
        for(int i = 0; i < numbers.length; i++) {
        	result *= Integer.parseInt(numbers[i]);
        }
        
        while(result > 0) {
        	answer[result % 10]++;
        	result /= 10;
        } 
        
        for(int i = 0; i < answer.length; i++) {
        	System.out.println(answer[i]);
        }
	}
}
