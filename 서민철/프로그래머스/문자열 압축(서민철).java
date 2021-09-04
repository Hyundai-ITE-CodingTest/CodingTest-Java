import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(String s) {
		int answer = s.length();

		for (int i = 1; i < s.length(); i++) {
			answer = Math.min(answer, func(s, i));
		}

		return answer;
	}

	// 문자열 s를 길이 len으로 압축한 문자열의 길이를 반환
	public int func(String s, int len) {
		String st = "";
		int i = 0;
		Integer cnt = 1; // 2ab에서 2를 저장하는 변수이다.
		String comp = s.substring(i, i + len); // 현재 압축하는 단어

		for (i = len; i < s.length(); i += len) {
			if (i + len > s.length()) {
				// 남은 글자가 길이 len 이상인지 확인
				continue;
			}

			// 현재 비교하려는 단어
			String tmp = s.substring(i, i + len);

			if (comp.equals(tmp)) {
				// 압축이 가능하다면 cnt 증가
				cnt += 1;
			} else {
				// 1ab면 1은 생략할 수 있음
				if (cnt > 1) {
					// 2ab에서 2를 붙이는 과정
					st += cnt.toString();
				}
				// 2ab에서 ab를 붙이는 과정
				st += comp;
				// 붙였으면 cnt는 1로 초기화, 압축하려는 단어 변경
				cnt = 1;
				comp = new String(tmp);
			}
		}
		
		// 마지막으로 남은 문자열 붙이는 과정
		if (cnt > 1) {
			st += cnt.toString();
		}

		st += comp;

		// 만약 14글자를 3글자로 압축한다면 2글자가 남는데, 해당 2글자를 처리하는 과정
		if (i != s.length()) {
			i -= len;
			st += s.substring(i, s.length());
		}

		return st.length();
	}
}