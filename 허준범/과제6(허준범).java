package homework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("시작수: ");
		int start = Integer.parseInt(bf.readLine());
		System.out.print("끝수: ");
		int end = Integer.parseInt(bf.readLine());
		System.out.print("배수: ");
		int n = Integer.parseInt(bf.readLine());

		int result = 0;
		for (int i = start; i <= end; i++) {
			if (i % n == 0)
				result += i;
		}
		System.out.println(result);
	}
}
