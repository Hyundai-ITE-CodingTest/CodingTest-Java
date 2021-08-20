package Projects8_17;

import java.util.Scanner;

public class Pro3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int A = input.nextInt();
		int B = input.nextInt();
		int C = input.nextInt();
		String num;
		int test = 6;
		int [] NumArray = new int[10];
		int Multiply = A * B * C;
		num = String.valueOf(Multiply);

		
		for(int i = 0; i < num.length(); i++) {
			for(int j = 0; j < NumArray.length; j++) {
			if(num.charAt(i) == Integer.toString(j).charAt(0)){
				NumArray[j]++;
				}
			}
		}
		
		System.out.println(NumArray[0]); // 0 갯수 출력
		for(int i = 1; i <NumArray.length;i++) { // 1~9 갯수 출력
			System.out.println(NumArray[i]);
		}

	}

}
