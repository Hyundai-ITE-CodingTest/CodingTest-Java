package boj;

import java.io.*;
import java.util.*;


public class Boj_4949 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            ArrayList<Character> stack = new ArrayList<>();
            int top = -1;
            String s = bf.readLine();

            if(s.equals(".")){
                break;
            }

            for (int i = 0; i < s.length(); i++){
                char temp = s.charAt(i);
                if(temp == '(' || temp == ')' || temp == '[' || temp == ']'){

                    stack.add(temp);
                    top++;
                    if(top > 0){
                        while(stack.get(top) - stack.get(top - 1) == 1 || stack.get(top) - stack.get(top - 1) == 2){

                            stack.remove(top);
                            top--;
                            stack.remove(top);
                            top--;
                            
                            if(top < 1){
                                break;
                            }
                        }
                    }
                }
            }
            if (stack.size() == 0){
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }   
}
