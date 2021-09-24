package week09;

import java.util.*;

public class 징검다리건너기 {
	public static int solution(int[] stones, int k) {
		int answer = 0;
		int left = 1;
		int right = Arrays.stream(stones).max().getAsInt();

		while (left <= right) {
			int mid = (left + right) / 2;
			int zero = 0;

			for (int stone : stones) {
				if (stone - mid <= 0)
					zero += 1; //못넘어 가는 돌의 갯수
				else
					zero = 0; //넘어가면 초기화

				if (zero >= k) //못넘어가는 횟수 초과시 탈출
					break;
			}
			
			if(zero < k)
				left = mid + 1;
			else {
				answer = mid;
				right = mid -1;
			}
		}
		
		return answer;
	}
	public static void main(String[] args) {
		System.out.println(solution(new int[] {2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
	}
}
