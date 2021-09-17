package week08;

import java.util.*;
import java.io.*;

public class 집합의표현_1717 {
	static int parent[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parent = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (c == 0) { // a b 집합을 합친다.
				union(a, b);
			} else { // 같은 부모인지 확인한다.
				if (getParent(a) == getParent(b))
					bw.write("YES");
				else
					bw.write("NO");
				bw.newLine();
			}			
		}
		bw.flush();
		bw.close();
		br.close();
	}

	public static int getParent(int n) { // 최상위 부모를 찾는 함수
		if (n == parent[n]) {
			return n;
		}
		return parent[n] = getParent(parent[n]);
	}

	public static void union(int a, int b) {
		int parentA = getParent(a);
		int parentB = getParent(b);

		if (parentA <= parentB) {
			parent[b] = parentA;
			parent[parentB] = parentA;
		} else {
			parent[a] = parentB;
			parent[parentA] = parentB;
		}
	}
}
