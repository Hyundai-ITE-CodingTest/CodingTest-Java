import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;

		while (!(str = br.readLine()).equals(".")) {
			if (!str.contains("[") && !str.contains("]") && !str.contains("(") && !str.contains(")")) {
				bw.append("yes\n");
			} else {
				if (check(str)) {
					bw.append("yes\n");
				} else {
					bw.append("no\n");
				}

			}
		}
		bw.flush();
		bw.close();

	}

	static boolean check(String str) {
		Deque<Character> stack = new ArrayDeque();
		boolean l_open = false;
		boolean b_open = false;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(' || str.charAt(i) == ')' || str.charAt(i) == '[' || str.charAt(i) == ']') {
				if (stack.size() != 0) {
					if(str.charAt(i) == ')'&& stack.peekLast()=='(') {
						stack.pollLast();
					}else if(str.charAt(i)==']' && stack.peekLast()=='[') {
						stack.pollLast();
					}else {
						stack.add(str.charAt(i));
					}
				} else {
					stack.add(str.charAt(i));
				}
			}

		}

		if(stack.size()>0) {
			return false;
		}

		return true;
	}
}
