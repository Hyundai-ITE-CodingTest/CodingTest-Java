package ex01;

import java.util.*;

public class Problem1_4 {
	public static void main(String[] args) {
		String before = new Scanner(System.in).nextLine();
		String after = "";
		
		for(int i=0; i<before.length(); i++) {
			char x = before.charAt(i);
			if(x+4 <= 'z') {
				after += (char)(x+4);
			}
			else {
				after += (char)(x+4 - 26);
			}
		}
		
		System.out.println(after);
	}
}
