import java.util.*;
class Solution {
    public String solution(String p) {
        String answer = "";
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        if(p.length() == 0) { // 빈 문자열이 들어왔을 때
            return answer;
        } else {
            int count = 0;
            for(int i=0; i<p.length(); i++) {
                //열린 괄호 들어오면
                if(p.charAt(i)=='(') {
                    count++;
                } else { // 닫힌 괄호 들어오면 
                    count--;
                }
                if(count < 0) { // 닫힌 괄호가 먼저 나오면 )(
                    flag = false;
                }
                if(count == 0) { //균형 잡힌 괄호 이거나, 올바르지 않다면 
                    String u = p.substring(0, i+1); //확인한 괄호
                    //재귀(확인하지 못한것), 마지막 값부터 끝까지 검사
                    String v = solution(p.substring(i+1));
                    if(flag == false) { //v가 false일 경우
                        //4-1/2/3 수행
                        sb.append('(').append(v).append(')');
                        for(int j=1; j<i; j++) { //4-4 수행
                            if(u.charAt(j) == '(') {
                                sb.append(')');
                            } else {
                                sb.append('(');
                            }
                        }
                    } else {//올바른 문자열은 뒤에 붙임
                        sb.append(u).append(v);
                    }
                    break;
                }
            }
            answer = sb.toString();
            return answer;
        }
    }
}
