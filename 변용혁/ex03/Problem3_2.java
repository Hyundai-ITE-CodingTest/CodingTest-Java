package ex03;

import java.util.*;

public class Problem3_2 {
	public static void main(String[] args) {
		String str = new Scanner(System.in).nextLine();
		int cal = 0;
		int scarp = 1; //급경사
		int height = 0;
		
		for(int i=0; i< str.length(); i++) {
			if(str.charAt(i) == '(') {
				height += 1;
				cal += height * scarp;
			}else if(str.charAt(i) == ')') {				
				cal += height * scarp;
				height -= 1;
			}else if(str.charAt(i) == '#') {
				if(scarp == 1) scarp = 2;
				else scarp = 1;
			}
		}
		System.out.println(cal);
	}
}
