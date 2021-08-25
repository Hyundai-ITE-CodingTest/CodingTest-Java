package kosa.ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class day0817_ex3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int result = 1;
	static int[] num_arr = new int[10];
	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		String[] str_arr = str.split(",");
		//구분자를 통해서 구분하여 문자열 배열에 넣어줌.

		for (int i = 0; i < str_arr.length; i++) {
			result *= Integer.parseInt(str_arr[i]);
		}
		// 배열의 수 만큼 값을 곱해줌
		String reslut_str = Integer.toString(result);
		for (int i = 0; i < reslut_str.length(); i++) {
			num_arr[reslut_str.charAt(i)-'0'-0]++;
		}// 문자열로 치환하여 각각의 문자가 몇번 쓰였는지 배열에 추가하여 확인

//		/첫째 줄에는 A×B×C의 결과에 0 이 몇 번 쓰였는지 출력한다. 


//		마찬가지로 둘째 줄부터 열 번째 줄까지 A×B×C의 결과에 1부터 9까지의 숫자가 각각 몇 번 쓰였는지 차례로 한 줄에 하나씩 출력한다.
		
		for (int i = 0; i <=9; i++) {
			System.out.println(num_arr[i]);
		}
	}

}
