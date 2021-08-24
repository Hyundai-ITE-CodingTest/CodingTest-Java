import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static boolean isbalance(String line) {
		Stack<Character> stack = new Stack<Character>();
		char op;
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == '(')
				stack.push('(');
			else if (line.charAt(i) == '[')
				stack.push('[');
			else if (line.charAt(i) == ')') {
				if (stack.isEmpty() || (op = stack.pop()) != '(')
					return false;
			} else if (line.charAt(i) == ']') {
				if (stack.isEmpty() || (op = stack.pop()) != '[')
					return false;
			}
		}
		if (stack.isEmpty())
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String line = bf.readLine();
			if (line.equals("."))
				break;

			if (isbalance(line))
				sb.append("yes\n");
			else
				sb.append("no\n");
		}
		System.out.println(sb);
	}
}
