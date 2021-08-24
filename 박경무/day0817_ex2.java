package kosa.ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class day0817_ex2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int min = 2100000000 , sum ;
	public static void main(String[] args) throws IOException {
//		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = br.readLine();
		String[] str_arr = str.split(",");
//		https://copycoding.tistory.com/289
		// 자세한 split 설명 참고
		for (int i = 0; i < str_arr.length; i++) {
			int num = Integer.parseInt(str_arr[i]);
			if(num %2 ==1 ) {
				sum += num;
				min = Math.min(min, num);
			}
		}
		
		if(sum ==0) {
			System.out.println(-1);
			return;
		}else {
			System.out.println(sum);
			System.out.println(min);
		}
		
	}

}
