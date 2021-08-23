package codingtest;

import java.util.Scanner;

public class N과M2_15650_변용혁 {
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		arr = new int[M + 1];
		visited = new boolean[N + 1];

		Solution(N, M, 0);
	}

	public static void Solution(int N, int M, int cnt) {
		if(cnt > 1 && arr[cnt-2] > arr[cnt-1]) return;
		if (cnt == M) { // 깊이가 m과 같으면 출력
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {// 방문 안한 숫자
				visited[i] = true; // 방문으로 바꿈
				arr[cnt] = i; //
				Solution(N, M, cnt + 1);
				visited[i] = false;// 돌아와서 방문 안한 숫자로 바꿈
			}
		}
	}
}
