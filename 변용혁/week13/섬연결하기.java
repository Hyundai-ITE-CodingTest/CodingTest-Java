package week13;

import java.util.*;

public class 섬연결하기 {
	static int[] island;

	public static int solution(int n, int[][] costs) {
		int answer = 0;
		island = new int[n];

		for (int i = 0; i < n; i++) { // 사이클 확인하기 위해 union find방식
			island[i] = i;
		}

		Arrays.sort(costs, new Comparator<int[]>() { // 비용순으로 정렬
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		for (int[] cost : costs) {
			int src = cost[0];
			int dst = cost[1];
			int pay = cost[2];
			
			if(island[src] != island[dst]) {
				if(getParent(island[src]) != getParent(island[dst])){
					answer += pay;
					union(getParent(island[src]), getParent(island[dst]));
				}
			}
		}

		return answer;
	}

	public static int getParent(int n) {
		if (island[n] == n)
			return n;

		return island[n] = getParent(island[n]);
	}
	
	public static void union(int a, int b) {
		if (a > b) {
			island[a] = b;
		} else {
			island[b] = a;
		}
	}

	public static void main(String[] args) {
		System.out
				.println(solution(4, new int[][] { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } }));
	}
}
