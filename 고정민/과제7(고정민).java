package day0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class AppleArchery {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine()); //사과의 개수
		int[] apples = new int[num];
		
		StringTokenizer st = new StringTokenizer(br.readLine()); // 공백 구분을 위한 StringTokenizer
		for(int i = 0; i<num;i++) {
			apples[i] = Integer.parseInt(st.nextToken());
		}
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		int sum=0;
		for(int i =0; i<num; i++) {
			if(str1.charAt(i)=='O'&&str2.charAt(i)=='O') {
				sum += apples[i];
			}
		}
		System.out.println(sum);
	}
}
