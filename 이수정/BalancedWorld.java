/*
백준에서 컴파일시 엔터가 추가로 입력되는 경우는 어떻게 해결해야하는지 모르겠음
*/
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BalancedWorld {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        Scanner scan = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while(true) {
            String str = br.readLine();
            if (str.equals(".")) {// 입력종료조건문
                break;
            } else {
                list.add(str);
            }
        }
        for(int i = 0; i< list.size(); i++) {
            list.set(i, list.get(i).replaceAll("[a-zA-Z\\s]", ""));
        }
        String[] str = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < list.get(i).length(); j++) {
                char ch = list.get(i).charAt(j);
                if(ch== '(' ||ch == '[') {
                    stack.push(ch);
                }else if(ch == ')') {
                    // 스택이 비어있거나 이전에 들어가 있는 값이 여는 괄호가 아닐경우
                    if(stack.empty() || stack.peek() != '(') {
                        str[i] = "no";
//                        bw.write("no");
                    }else{ //스택에 값이 있거나, 닫힌 괄호일 경우 내용물 제거
                        stack.pop();
                    }
                }else if(ch == ']') {
                    if(stack.empty() || stack.peek() != '[') {
                        str[i] = "no";
//                        bw.write("no");
                    }else {
                        stack.pop();
                    }
                }
            }
            if(stack.empty()){
                str[i] = "yes";
//                bw.write("yes");
            }
            bw.write("\n");
        }
        for(int i = 0; i<str.length; i ++){
//            bw.write(str[i]+'\n');
            System.out.println(str[i]);
        }
//        br.close();
//        bw.flush();
//        bw.close();
        System.out.print(str[str.length-1]);
    }
}
