package homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] line = bf.readLine().split(",");

		int sumVal = 0;
		int minVal = Integer.MAX_VALUE;
		for (int i = 0; i < line.length; i++) {
			int val = Integer.parseInt(line[i]);
			if (val % 2 == 1) {
				sumVal += val;
				minVal = Math.min(minVal, val);
			}
		}

		System.out.println(sumVal);
		System.out.println(minVal);
	}
}
