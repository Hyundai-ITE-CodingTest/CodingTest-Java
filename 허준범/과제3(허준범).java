package homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] line = bf.readLine().split(",");
		int mulVal = 1;
		for (int i = 0; i < line.length; i++) {
			mulVal *= Integer.parseInt(line[i]);
		}
		// 문자열로 변환
		String mulValStr = String.valueOf(mulVal);
		int[] arr = new int[10];

		for (int i = 0; i < mulValStr.length(); i++) {
			int num = mulValStr.charAt(i) - '0';
			arr[num]++;

		}

		for (int i = 0; i < 10; i++) {
			System.out.println(arr[i]);
		}

	}
}
