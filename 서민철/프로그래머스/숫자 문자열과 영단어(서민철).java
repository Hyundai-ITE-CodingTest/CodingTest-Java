import java.util.*;
import java.io.*;

class Solution {
	public int solution(String s) {
		int answer = 0;
		int idx = 0;

		StringBuilder sb = new StringBuilder();

		while (idx < s.length()) {
			if ('0' <= s.charAt(idx) && s.charAt(idx) <= '9') {
				sb.append(s.charAt(idx));
				idx += 1;
			} else {
				String tmp = s.substring(idx);

				if (tmp.startsWith("zero")) {
					sb.append('0');
					idx += 4;
				} else if (tmp.startsWith("one")) {
					sb.append('1');
					idx += 3;
				} else if (tmp.startsWith("two")) {
					sb.append('2');
					idx += 3;
				} else if (tmp.startsWith("three")) {
					sb.append('3');
					idx += 5;
				} else if (tmp.startsWith("four")) {
					sb.append('4');
					idx += 4;
				} else if (tmp.startsWith("five")) {
					sb.append('5');
					idx += 4;
				} else if (tmp.startsWith("six")) {
					sb.append('6');
					idx += 3;
				} else if (tmp.startsWith("seven")) {
					sb.append('7');
					idx += 5;
				} else if (tmp.startsWith("eight")) {
					sb.append('8');
					idx += 5;
				} else {
					sb.append('9');
					idx += 4;
				}
			}
		}

		return Integer.parseInt(sb.toString());
	}
}