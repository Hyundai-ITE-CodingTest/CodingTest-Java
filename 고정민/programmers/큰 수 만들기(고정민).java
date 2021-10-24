import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
		
		Stack<Character> stack = new Stack<>();
		
		for (int i=0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k > 0) {
                stack.pop();
                k -=1;
            }
            stack.push(c);
        }
		if(k>0) {
			stack.pop();
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
        
        return sb.reverse().toString();
    }
}
