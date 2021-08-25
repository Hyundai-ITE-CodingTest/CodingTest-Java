package codingtest;

import java.io.*;
import java.util.*;
//visited 삭제 -> br bw 사용 -> 시간초과 해결
public class N과M3_15651_변용혁 {
	static int[] arr;
//	static boolean[] visited;
	static BufferedReader br;
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new int[M + 1];
//		visited = new boolean[N + 1];

		Solution(N, M, 0);
		
		bw.flush();
		bw.close();
		br.close();
	}

	public static void Solution(int N, int M, int cnt) throws IOException {
		if (cnt == M) { // 깊이가 m과 같으면 출력
			for (int i = 0; i < M; i++) {
				bw.write(arr[i] + " ");
			}
			bw.newLine();
			return;
		}

		for (int i = 1; i <= N; i++) {
//				visited[i] = true; // 방문으로 바꿈
				arr[cnt] = i; //
				Solution(N, M, cnt + 1);
//				visited[i] = false;// 돌아와서 방문 안한 숫자로 바꿈
			
		}
	}
}
