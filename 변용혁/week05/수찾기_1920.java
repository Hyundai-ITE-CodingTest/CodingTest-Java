package week05;

import java.io.*;
import java.util.*;

public class 수찾기_1920 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int[] arr;

	public static void main(String[] args) throws Exception {

		N = Integer.parseInt(br.readLine());
		String[] str1 = br.readLine().split(" ");
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str1[i]);
		}
		Arrays.sort(arr);
		int M = Integer.parseInt(br.readLine());
		String[] str2 = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			Solution(Integer.parseInt(str2[i]));
			bw.newLine();
		}

		bw.flush();
		bw.close();
		br.close();
	}

	public static void Solution(int x) throws IOException {
		int left = 0;
		int right = N - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (x < arr[mid]) {
				right = mid - 1;
			} else if (x > arr[mid]) {
				left = mid + 1;
			} else { // 맨 밑으로 줘서 분기에서 시간을 단축??
				bw.write("1");
				return;
			}
		}
		bw.write("0");
	}
}
