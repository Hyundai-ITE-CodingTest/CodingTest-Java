package Projects8_20;

import java.util.Scanner;

public class Pro10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String root = input.next();
		char [] stair = new char[root.length()];
		int upCount = 0;
		int height = 0;
		int downCount = 0;
		int Boost = 2;
		int Boostcount = 0; 
		
		for(int i = 0 ; i < root.length(); i++) {
			stair[i] = root.charAt(i);
		}
		
		for(int i = 0 ; i < root.length(); i++) {
			if(stair[i] == '#' && Boostcount == 0) {
				Boostcount = 1;
			}
			else if(stair[i] == '#' && Boostcount == 1) {
				Boostcount = 0;
			}
			if(stair[i] == '(' && Boostcount == 1) {
				height++;
				upCount = upCount + height * 1 * Boost;
				
			}
			else if(stair[i] == '(' && Boostcount == 0) {
				height++;
				upCount = upCount + height * 1 ;
				
			}
			else if(stair[i] == ')' && Boostcount == 1) {
				downCount = downCount + height * 1 * Boost;
				height--;
				}
			else if(stair[i] == ')' && Boostcount == 0) {
				downCount = downCount + height * 1 ;
				height--;
				}
			}
		System.out.println(upCount+downCount);
		
	}

}
