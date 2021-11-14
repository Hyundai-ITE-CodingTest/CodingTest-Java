import java.util.*;

class Solution {
    public String solution(String p) {
        StringBuilder answer = new StringBuilder();
        if(!p.equals("")) { // 공백이 아니라면
            String[] uv = u2v(p);
            if(isright(uv[0])) { // 3-
                answer.append(uv[0]).append(solution(uv[1]));
            } else { // 4-
                StringBuilder reflect = new StringBuilder();
                uv[0] = uv[0].substring(1, uv[0].length()-1);
                for(int i=0; i < uv[0].length(); i++) {
                    if(uv[0].charAt(i) == '(')
                        reflect.append(")");
                    else if(uv[0].charAt(i) == ')')
                        reflect.append("(");
                }
                answer.append("(").append(solution(uv[1])).append(")").append(reflect);
            }
        } else { // 공백이면, 빈 문자열
            return "";
        }
        return answer.toString();
    }
    
    
    public static String[] u2v(String p) { // 2 - 균형잡힌 괄호 문자열
        String[] uv = new String[2];
        
        for(int i=0; i < p.length(); i++) {
            uv[0] = p.substring(0, i+1);
            uv[1] = p.substring(i+1, p.length());
            int countL = 0, countR = 0;
            for(int j=0; j < uv[0].length(); j++) {
                if(uv[0].charAt(j) == '(')
                    countL++;
                else if(uv[0].charAt(j) == ')')
                    countR++;
            }
            if(countL == countR)
                break;
        }
        return uv;
    } // u2v
    
    
    public static boolean isright(String u) { // 올바른 괄호 문자열인가?
        boolean ispossible = true;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i < u.length(); i++) {
            char op = u.charAt(i);
            if(op == '(') {
                stack.push(op);
            } else if(op == ')') {
                if(stack.empty() || (op = stack.pop()) != '(') {
                    ispossible = false;
                    break;
                }
            }
        }
        return ispossible;
    } // isright
}