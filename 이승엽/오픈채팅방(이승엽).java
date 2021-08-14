import java.util.*;

class Solution {
	public String[] solution(String[] record) {
		String[] answer;
		StringTokenizer st;
		HashMap<String, String> map = new HashMap<>();
		ArrayList<String> answer_list = new ArrayList<>();
		
		for (String str : record) {	// hash map 저장
			st = new StringTokenizer(str);
			String st1 = st.nextToken();
			String st2 = st.nextToken();
			String st3 = null;

			if (st1.equals("Enter")) {
				st3 = st.nextToken();
				map.put(st2, st3);
				answer_list.add(st1 + " " + st2);
			} else if (st1.equals("Change")) {
				st3 = st.nextToken();
				map.replace(st2, st3);
			} else {
				answer_list.add(st1 + " " + st2);
			}
		}

		answer = new String[answer_list.size()];
		for (int i = 0; i < answer_list.size(); i++) {
			st = new StringTokenizer(answer_list.get(i));
			String st1 = st.nextToken();
			String st2 = st.nextToken();
			if (st1.equals("Enter")) {
				answer[i] = map.get(st2) + "님이 들어왔습니다.";
			} else {
				answer[i] = map.get(st2) + "님이 나갔습니다.";
			}
		}
		return answer;
	}
}