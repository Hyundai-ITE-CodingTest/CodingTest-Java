package kosa.team3_day1;

import java.io.*;
import java.util.*;

public class boj_4949균형잡힌세상 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		Loop1: while (true) {
			String str = br.readLine();
			Stack<Integer> stack = new Stack();
			if (str.equals(".")) {
				break;
			}
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(') {
					stack.add(1);
				} else if (str.charAt(i) == '[') {
					stack.add(2);
				} else if (str.charAt(i) == ')') {
					if (stack.isEmpty()) {
						sb.append("no").append("\n");
						continue Loop1;
					} else {
						int now = stack.pop();
						if (now != 1) {
							sb.append("no").append("\n");
							continue Loop1;
						}
					}

				} else if (str.charAt(i) == ']') {
					if (stack.isEmpty()) {
						sb.append("no").append("\n");
						continue Loop1;
					} else {
						int now = stack.pop();
						if (now != 2) {
							sb.append("no").append("\n");
							continue Loop1;
						}
					}
				}
			}
			if(!stack.isEmpty()) {
				sb.append("no").append("\n");
				continue Loop1;
			}
			sb.append("yes").append("\n");

		}
		System.out.println(sb);
	}

}
// 실수한점, 괄호를 제대로 닫지 않은 case는 체크했지만 괄호를 먼저 닫는것은 체크 안했다.