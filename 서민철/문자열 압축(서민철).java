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

	// ���ڿ� s�� ���� len���� ������ ���ڿ��� ���̸� ��ȯ
	public int func(String s, int len) {
		String st = "";
		int i = 0;
		Integer cnt = 1; // 2ab���� 2�� �����ϴ� �����̴�.
		String comp = s.substring(i, i + len); // ���� �����ϴ� �ܾ�

		for (i = len; i < s.length(); i += len) {
			if (i + len > s.length()) {
				// ���� ���ڰ� ���� len �̻����� Ȯ��
				continue;
			}

			// ���� ���Ϸ��� �ܾ�
			String tmp = s.substring(i, i + len);

			if (comp.equals(tmp)) {
				// ������ �����ϴٸ� cnt ����
				cnt += 1;
			} else {
				// 1ab�� 1�� ������ �� ����
				if (cnt > 1) {
					// 2ab���� 2�� ���̴� ����
					st += cnt.toString();
				}
				// 2ab���� ab�� ���̴� ����
				st += comp;
				// �ٿ����� cnt�� 1�� �ʱ�ȭ, �����Ϸ��� �ܾ� ����
				cnt = 1;
				comp = new String(tmp);
			}
		}
		
		// ���������� ���� ���ڿ� ���̴� ����
		if (cnt > 1) {
			st += cnt.toString();
		}

		st += comp;

		// ���� 14���ڸ� 3���ڷ� �����Ѵٸ� 2���ڰ� ���µ�, �ش� 2���ڸ� ó���ϴ� ����
		if (i != s.length()) {
			i -= len;
			st += s.substring(i, s.length());
		}

		return st.length();
	}
}