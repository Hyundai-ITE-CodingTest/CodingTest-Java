package codingtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Balanced {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		StringBuilder sb = new StringBuilder();
		
		while(!(line = br.readLine()).equals(".")) {
			boolean flag = solution(line);
			
			if(flag == true) {
				sb.append("yes");
			}else {
				sb.append("no");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString().trim());
	}
	
	public static boolean solution(String line) {
		HashMap<Character, Character> strmap = new HashMap<>();
		strmap.put('(', ')');
		strmap.put(')', '(');
		strmap.put('[', ']');
		strmap.put(']', '[');
		
		Stack<Character> stack = new Stack<>();
		for(int i=0; i < line.length(); i++) {
			char ch = line.charAt(i);
			if(ch == '(' || ch == '[') {
				stack.push(ch);
			}
			else if(ch == ')' || ch == ']') {
				if(stack.isEmpty() || stack.pop() != strmap.get(ch)) {
					return false;
				}
			}
		}
		
		
		if(stack.size() == 0) {
			return true;
		}
		return false;
	}
}
