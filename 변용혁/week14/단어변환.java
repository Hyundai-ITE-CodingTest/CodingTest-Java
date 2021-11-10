import java.util.*;

class Solution {
	public int solution(String begin, String target, String[] words) {
		int answer = 0;
		Queue<String> q1 = new LinkedList();
		List<String> wordss = new LinkedList();

		for (String w : words) {
			wordss.add(w);
		}

		if (!wordss.contains(target))
			return 0;

		q1.add(begin);

		while (wordss.size() > 0) {

			answer++;
			Queue<String> q2 = new LinkedList();

			while (q1.size() > 0) {
				String temp = q1.poll();

				for (String w : wordss) {
					int count = 0;
					for (int i = 0; i < w.length(); i++) {
						if (w.charAt(i) != temp.charAt(i)) {
							count++;
						}
					}

					if (count == 1) { // 알파벳 한개만 다를경우 q2에 추가
						q2.add(w);
					}
				}
			}

			if (q2.contains(target)) {
				return answer;
			} else {
				String temp = null;
				while (q2.size() > 0) {
					temp = q2.poll();
					q1.add(temp);
					wordss.remove(temp);
				}
			}
		}

		return answer;
	}
}
