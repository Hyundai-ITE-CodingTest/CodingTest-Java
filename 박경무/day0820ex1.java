package kosa.ex3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class day0820ex1 {
	static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	static int sum;
	static long min = 410000000;
	public static void main(String[] args) throws IOException {
		int[] intarr = new int[7];
		String[] strarr = new String[7];
		String str = br.readLine();
		strarr = str.split(",");
		// , 로 구분하여 배열삽입
		for (int i = 0; i < strarr.length; i++) {
			intarr[i]=Integer.parseInt(strarr[i].trim());
		}
		// 배열 값을 int로 변경
		for (int i = 0; i < intarr.length; i++) {
			//홀수확인
			if(intarr[i]%2==1) {
				//홀수 전체 합
				sum+=intarr[i];
				//홀수 최소값 구하기
				if(min>intarr[i]) {
					min=intarr[i];
				}
			}
		}
		
		if(sum==0) {
			System.out.println(-1);
		}else {
			System.out.println(sum);
			System.out.println(min);
		}
/*
12, 77, 38, 41, 53, 92, 85
2, 2, 2, 2, 2, 2, 2
10, 2, 8, 6, 16, 8, 10


*/
	}

}
