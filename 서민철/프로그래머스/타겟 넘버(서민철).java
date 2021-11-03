class Solution {
	public static int answer = 0;
	public static int t;

	public int solution(int[] numbers, int target) {
		t = target;
		DFS(numbers, 0, 0);
		return answer;
	}

	public void DFS(int[] numbers, int sum, int idx) {
		if (idx == numbers.length) {
			if (sum == t) {
				answer += 1;
			}
			return;
		}

		sum += numbers[idx];
		DFS(numbers, sum, idx + 1);
		sum -= 2 * numbers[idx];
		DFS(numbers, sum, idx + 1);
	}
}