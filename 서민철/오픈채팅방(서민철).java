import java.util.ArrayList;
import java.util.HashMap;

class Solution {
	public String[] solution(String[] record) {
		ArrayList<String> answer = new ArrayList<String>();
		HashMap<String, String> map = new HashMap<String, String>();

		// HashMap 동기화
		for (int i = 0; i < record.length; i++) {
			String[] word = record[i].split(" ");
			if (word[0].equals("Leave")) {
				// Leave로 들어온 경우
				continue;
			} else {
				// Enter, Change로 들어온 경우
				map.put(word[1], word[2]);
			}
		}
		
		// 로그 출력
		for (int i = 0; i < record.length; i++) {
			String[] word = record[i].split(" ");
			if (word[0].equals("Enter")) {
				// Enter 메세지
				String tmp = map.get(word[1]) + "님이 들어왔습니다.";
				answer.add(tmp);
			} else if (word[0].equals("Leave")) {
				// Leave 메세지
				String tmp = map.get(word[1]) + "님이 나갔습니다.";
				answer.add(tmp);
			} // Change 메세지는 저장할 필요 없음
		}

		return answer.toArray(new String[answer.size()]);
	}
}