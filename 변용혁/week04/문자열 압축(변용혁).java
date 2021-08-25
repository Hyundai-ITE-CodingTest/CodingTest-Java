package programmers;

import java.util.*;

public class Solution {
	public static int solution(String s) {

		int len = s.length();
		List<Integer> size = new ArrayList<Integer>();
		String result = "";

		if (len == 1) // 예외
			return 1;

		for (int cut = 1; cut < (int) (len / 2) + 1; cut++) {
			int count = 1; // 압축 횟수
			int i = 0;
			String comStr = s.substring(0, cut); // cut 만큼 자른 substr

			for (i = cut; i < len; i += cut) {
				if (i + cut > len)
					continue;
				String temp = s.substring(i, i + cut);
				if (comStr.equals(temp)) { // comStr과 같으면 cnt +1
					count += 1;
				} else { // 뒤에 문자열이 압축이 안되면
					if (count == 1)
						result += comStr;//1이면 1빼고 추가
					else
						result += Integer.toString(count) + comStr; // 숫자 + 압축된 문자열

					comStr = temp; // 초기화
					count = 1;
				}
			}
			if (count == 1)
				result += comStr;
			else
				result += Integer.toString(count) + comStr;

			if (i != len) { //cut보다 짧아서 남은 문자열 추가
				i -= cut;
				result += s.substring(i, len);
			}
			size.add(result.length());
			result = "";
		}

		return Collections.min(size);
	}
}
