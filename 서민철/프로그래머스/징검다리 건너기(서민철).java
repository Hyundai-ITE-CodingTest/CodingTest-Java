import java.io.*;
import java.util.*;

class Solution {
	public int solution(int[] stones, int k) {
		// 디딤돌에 적힌 숫자 stones
		// 한 번에 건너뛸 수 있는 디딤돌의 최대 칸 수 k

		int answer = 0;

		int left = 0;
		int right = 200000000;

		while (left <= right) {
			int mid = (left + right) / 2;

			// 건널 수 있으면 인원의 수를 늘려본다.
			if (check(stones, k, mid)) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		// 최대 몇 명까지 징검다리를 건널 수 있는지
		return answer;
	}

	// n명의 친구가 징검다리를 건널 수 있는가?
	public boolean check(int[] stones, int k, int n) {
		// 현재 위치를 저장한다.
		int cur = -1;

		while (cur + k < stones.length) {
			for (int i = cur + 1; i <= cur + k; i++) {
				if (stones[i] >= n) {
					cur = i;
					break;
				}

				if (i == cur + k) {
					return false;
				}
			}
		}
		return true;
	}
}