import java.util.ArrayList;
import java.util.HashMap;

class Solution {
	public String[] solution(String[] record) {
		ArrayList<String> answer = new ArrayList<String>();
		HashMap<String, String> map = new HashMap<String, String>();

		// HashMap ����ȭ
		for (int i = 0; i < record.length; i++) {
			String[] word = record[i].split(" ");
			if (word[0].equals("Leave")) {
				// Leave�� ���� ���
				continue;
			} else {
				// Enter, Change�� ���� ���
				map.put(word[1], word[2]);
			}
		}
		
		// �α� ���
		for (int i = 0; i < record.length; i++) {
			String[] word = record[i].split(" ");
			if (word[0].equals("Enter")) {
				// Enter �޼���
				String tmp = map.get(word[1]) + "���� ���Խ��ϴ�.";
				answer.add(tmp);
			} else if (word[0].equals("Leave")) {
				// Leave �޼���
				String tmp = map.get(word[1]) + "���� �������ϴ�.";
				answer.add(tmp);
			} // Change �޼����� ������ �ʿ� ����
		}

		return answer.toArray(new String[answer.size()]);
	}
}