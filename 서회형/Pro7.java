package Projects8_18;

import java.util.Scanner;

public class Pro3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int [] Score = new int[N];
		char[] Obstacle1 = new char[N];
		char[] Obstacle2 = new char[N];
		int scoreSum = 0;
		for(int i = 0; i < N; i++) {
			Score[i] = input.nextInt();
		}
		String Ob1 = input.next().toLowerCase();
		String Ob2 = input.next().toLowerCase();
		for(int i = 0; i < N; i++) {
			Obstacle1[i] = Ob1.charAt(i);
			Obstacle2[i] = Ob2.charAt(i);
		} 
		
		for(int i = 0; i < N; i++) {
			if(Obstacle1[i] == 'o' && Obstacle2[i] == 'o') {
				scoreSum += Score[i];
			}
		}
		
		System.out.println("총 점수: " + scoreSum);
	}

}
