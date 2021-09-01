package team3.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2751수정렬하기2 {
	static BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int[] arr= new int[n];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i]= Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}

}
