package ars;

import java.util.*;

public class Homework4 {
	public static void main(String[] args) {
		String input = "hkraukq";
		String output = "";
		char[] arr = new char[input.length()];
		
		for(int i = 0; i<input.length(); i++) {
			arr[i] = input.charAt(i);
			arr[i] = (char)(arr[i] + 4);
			output += arr[i];
		}
		System.out.println(output);
	}

}
