import java.util.*;
import java.io.*;

class Solution {
	public int solution(int[] scoville, int K) {
		int answer = 0;

		// 섞은 음식의 스코빌 지수 =
		// 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// o1 - o2: 오름차순
				// o2 - o1: 내림차순
				return o1 - o2;
			}
		});

		for (int scov : scoville) {
			pq.add(scov);
		}

		// pq가 반환하는 최소값이 K 이상일 때까지 반복
		while (pq.size() > 1 && pq.peek() < K) {
			answer += 1;

			int item1 = pq.poll();
			int item2 = pq.poll();

			int newScov = item1 + item2 * 2;
			pq.add(newScov);
		}

		if (pq.peek() < K) {
			return -1;
		}

		return answer;
	}
}