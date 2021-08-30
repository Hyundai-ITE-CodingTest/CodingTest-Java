package team3.day3;

/*
 * 아이디어
 * N개의 원판을 옮기려면 
 * 1. N-1개의 원판을 2로 옮긴다.
 * 2. 맨아래 원판을3으로 옮긴다
 * 3. N-1개의 원판을 3으로 옮긴다. 
 * N-2개의 원판을 옮기려면 
 * ... 반복 
 * 
 */
import java.util.Scanner;

public class boj하노이탑이동순서 {
	static int cnt;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		hanoi(n, 1, 3);
		System.out.println(cnt);
		System.out.println(sb);
	}

	// 옮겨야할 블록 수, 지금위치, 옮길 위치
	static void hanoi(int n, int from, int to) {
		if (n == 1) {
			sb.append(from).append(" ").append(to).append("\n");
			cnt++;
			return;
			//
		} else {
			hanoi(n-1,from,6-from-to);
			sb.append(from).append(" ").append(to).append("\n");
			cnt++;
			hanoi(n-1,6-from-to,to);
			
		}

	}
}
