class Solution {
	public String solution(int n) {
		String[] numbers = { "4", "1", "2" };
		String answer = "";

		while (n > 0) {
			int num = n % 3;
			n /= 3;

			if (num == 0)
				n--;

			answer = numbers[num] + answer;
		}

		return answer;
	}
}
