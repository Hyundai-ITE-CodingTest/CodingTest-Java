package homework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] apples = new int[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			apples[i] = Integer.parseInt(st.nextToken());
		}

		String[] blocks = bf.readLine().split("");
		String[] blocks2 = bf.readLine().split("");
		int result = 0;
		for (int i = 0; i < blocks.length; i++) {
			if (blocks[i].equals("O") && blocks[i].equals(blocks2[i])) {
				result += apples[i];
			}
		}

		System.out.println(result);
	}
}
