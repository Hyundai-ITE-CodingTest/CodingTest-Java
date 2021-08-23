package CodingTest8_19;

import java.util.Scanner;

public class Hansu {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
				
		int N = input.nextInt();
		
		int Hcount = 0;
		
		if(N < 100) {
			System.out.println(N);
		}
		else {
			Hcount = 99;
			for(int i = 100; i <= N; i++) {
				if(HanNumber(i) == 1) {
					Hcount++;
				}
			}
			if( N == 1000) {
				Hcount--;
			}
			System.out.println(Hcount);
		}
		
		

	}
	public static int HanNumber(int x) {
		int Hnum = (x /100) % 10;
		int Tnum = (x / 10) % 10;
		int Onum = x % 10;
		//등차 수열의 법칙
		if ( Tnum * 2 == Hnum + Onum ) {
			return 1;
		}
		
		return 0;
	}

}
