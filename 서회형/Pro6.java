package Projects8_18;

import java.util.Scanner;

public class Pro2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("시작수: ");
		int StartNum = input.nextInt();
		System.out.print("끝수: ");
		int EndNum = input.nextInt();
		System.out.print("배수: ");
		int MultiNum = input.nextInt();
		int sum = 0;
		int count = MultiNum;
		boolean done = true;
		
		
		while(count < StartNum) {
			count = count + MultiNum;
		}
		
		
		while(count <= EndNum) {
			sum += count;
			count = count + MultiNum;
		}
		System.out.println(sum);
	}

}
