import java.io.*;
import java.util.*;

class Solution {
	public String solution(String number, int k) {
		StringBuilder answer = new StringBuilder();
		
		// 뽑아야할 숫자의 개수
		int size = number.length() - k;

		int left = 0;
		int right = number.length() - size;

		for (int i = 0; i < number.length() - k; i++) {
			int tmp = checkFront(number, left, right);
			answer.append(number.charAt(tmp));
			left = tmp + 1;
			right += 1;
		}

		return answer.toString();
	}

	// a ~ b까지의 수 중 가장 큰 수의 인덱스를 반환한다.
	public int checkFront(String number, int a, int b) {
		int idx = a;
		int maxVal = number.charAt(a) - '0';

		for (int i = a; i <= b; i++) {
			int tmp = number.charAt(i) - '0';
			if (maxVal < tmp) {
				maxVal = tmp;
				idx = i;
			}
		}

		return idx;
	}
}