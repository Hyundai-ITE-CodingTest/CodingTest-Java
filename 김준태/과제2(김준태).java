package day14_Quiz;

import java.util.ArrayList;
import java.util.Collections;


public class Quiz2 {
	public static void main(String[] args) {
		int[] input = {12, 77, 38, 41, 53, 92, 85};
		solution(input);
	}
	
	public static void solution (int[] array) {
		ArrayList<Integer> list = new ArrayList();
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			if(array[i] % 2 != 0) {
				list.add(array[i]);
				sum += array[i];
			}
		}
		if (list.size() <= 0) {
			System.out.println(-1);
		}else {
			Collections.sort(list);
			System.out.println(sum);
			System.out.println(list.get(0));
		}
	}
}
