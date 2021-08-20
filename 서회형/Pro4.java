package Projects8_17;

import java.util.Scanner;

public class Pro4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		String password = input.next();
		char [] passwordStore = new char[password.length()];
		char [] newPasswordStore = new char[password.length()];
		for(int i = 0; i < password.length();i++) {
			passwordStore[i] = password.charAt(i);
		}

		for(int i = 0; i < password.length();i++) {
			if(password.charAt(i) == 'w' || password.charAt(i) == 'x' || password.charAt(i) == 'y' || password.charAt(i) == 'z') {
				newPasswordStore[i] = ((char)(passwordStore[i]-22));
			}
			else {
				newPasswordStore[i] = ((char)(passwordStore[i]+4));
		
			}
		}
		
		for(int i = 0; i < password.length();i++) {
			System.out.print(newPasswordStore[i]);
		}
	}

}
