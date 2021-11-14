import java.util.HashMap;
import java.util.Stack;

class Solution {
    //괄호 뒤집기
	public String reverseString(String str) {
		String answer = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				answer += ')';
			} else {
				answer += '(';
			}
		}
		return answer;
	}
    
    //올바른 괄호 문자열 판별
	public static boolean isCorrectString(String str) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				stack.add('(');
			} else if (str.charAt(i) == ')') {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			}
		}

		if (stack.size() > 0) {
			return false;
		}
		return true;
	}

    
    //올바른 문자열로 만들기
	public String makeCorrectString(String str) {
		
		if (isCorrectString(str)) {
			return str;
		}
		
		// 올바른 문자열이 아니라면 균형잡힌 괄호 문자열 분리
		int left = 0;
		int right = 0;

		int pos = str.length();
		for (int i = 0; i < str.length(); i++) {
			if (left == right && left > 0) {
				pos = i;
				break;
			}

			if (str.charAt(i) == '(') {
				++left;
				continue;
			}

			if (str.charAt(i) == ')') {
				++right;
				continue;
			}
		}

		// System.out.print(pos);
		String u = str.substring(0, pos);
		System.out.println("u " + u);
		String v = str.substring(pos);
		System.out.println("v " + v);
		

		if (isCorrectString(u)) {
			return u + makeCorrectString(v);
		}
		

		String temp = "";
		temp +="(" + makeCorrectString(v) + ")";
		temp += reverseString(u.substring(1, u.length() - 1));

		return temp;
	}
    
    public String solution(String p) {
        return makeCorrectString(p);
    }
}
