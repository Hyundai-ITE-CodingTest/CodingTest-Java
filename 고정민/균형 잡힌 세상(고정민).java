import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			input = br.readLine();
			boolean flag = true;
			Stack<Character> stack = new Stack<>();
			if(input.equals("."))	break;
			
			for(int i = 0; i<input.length();i++) {
				char ch = input.charAt(i);
				if(ch=='(' || ch=='[') //여는 괄호일 때 
					stack.push(ch);
				else if(ch==')') {
					if(!stack.isEmpty() && stack.peek()=='(')	stack.pop();
					else{
						flag = !flag;
						break;
					}
				}else if(ch==']') {
					if(!stack.isEmpty() && stack.peek()=='[')	stack.pop();
					else{
						flag = !flag;
						break;
					}
				}
			}
			
			if(flag && stack.isEmpty())	sb.append("yes\n");
			else sb.append("no\n");
		}
		System.out.println(sb.toString());
	}
}
