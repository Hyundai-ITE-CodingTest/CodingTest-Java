package code9_22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class 단어정렬 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int N = input.nextInt();
		
		ArrayList<String> arr = new ArrayList<String>();
		
		for(int i = 0; i < N; i++) {
			String word = input.next();
			if(!arr.contains(word)) {
				arr.add(word);
			}
		}
		Collections.sort(arr, new Comparator<String>(){
			@Override
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}
				else
				return s1.length() - s2.length();
			}
		});
		
		for(String s : arr) {
			System.out.println(s);
		}
		
	}
}
