package Projects8_17;

import java.util.Scanner;

public class Pro2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int [] Num = new int[7];
		int count = 0;
		int sum = 0; //홀수들의 합을 저장할 변수
		int oddMin = 0; 
		for(int i = 0 ; i < Num.length; i++) {
			Num[i] = input.nextInt();
			if(Num[i] % 2 == 1) {
				sum += Num[i];
				oddMin = Num[i];
				count++;
			}
		}
		for(int i = 0; i < Num.length; i++) {
			if(Num[i] % 2 == 1) {
				oddMin = Num[i];
				break;
			}
		}
		
		for(int i = 0; i < Num.length; i++) {
			if(oddMin > Num[i] && Num[i] %2 == 1 ) {
				oddMin = Num[i];
			}
		}
		
		System.out.println(sum);
		if(count != 0) {
		System.out.println(oddMin);
		}
		else {
			System.out.println(-1);
		}
	}

}
