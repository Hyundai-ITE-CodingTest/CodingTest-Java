class Solution {
	public int solution(String s) {
		int answer = s.length();
		
		for (int i = 1; i <= s.length() / 2; i++) { // 1,2,3,.. 길이의 절반만큼 자를 경우 
			String temp = "";
			String before = s.substring(0, i); 
			int check = 1;
			for (int j = i; j < s.length(); j += i) {
				String now;
				if (j + i < s.length()) {
					now = s.substring(j, j + i);
				} else {// 마지막 길이 부족할 경우
					now = s.substring(j);
				}

				if (now.equals(before)) {
					check++;
				} else {
					if (check == 1) { // 1번만 반복인 경우 그냥 추가
						temp += before;
					} else { // 2번 이상 반복은 숫자 + 문자 추가
						temp += check + before;
					}
					before = now; 
					check = 1; 
				}
			}
			
			if (check == 1) { // 마지막으로 남은 문자열 처리
				temp += before;
			} else {
				temp += check + before;
			}

			answer = Math.min(answer, temp.length()); // 최소값 비교
		}

		return answer;
	}
}