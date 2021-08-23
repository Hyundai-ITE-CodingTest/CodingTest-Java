package codingtest;

import java.io.*;
import java.util.*;

public class 균형잡힌세상_4949_변용혁 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<String> answer = new ArrayList<String>();

		while (true) {
			String temp = br.readLine();
			if (temp.equals("."))
				break;
			Stack<Character> stack = new Stack<Character>();
			boolean flag = true;

			for (int i = 0; i < temp.length(); i++) {
				char x = temp.charAt(i);

				if (x == '(' || x == '[') {
					stack.push(x);
				} else if (x == ')') {
					if (stack.size() != 0 && stack.peek() == '(')
						stack.pop();
					else {
						flag = false;
						break;

					}
				} else if (x == ']') {
					if (stack.size() != 0 && stack.peek() == '[')
						stack.pop();
					else {
						flag = false;
						break;
					}
				}

			}
			if (stack.size() == 0 && flag)
				answer.add("yes");
			else
				answer.add("no");
		}

		for(String s:answer) {
			System.out.println(s);
		}

	}
}
