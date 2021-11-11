import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack();
        
        //moves에서 뽑아서 숫자를 스택에 담는다.
        //이 전의 숫자와 같으면 없앤 뒤, answer++;
        for(int i=0; i<moves.length; i++){
            int location = moves[i] - 1;
            boolean check=false;
            for(int j=0; j<board.length; j++){
                
                //location에 인형이 있을경우
                if(board[j][location]!=0 && !check){
                    check = true;
                    int target = board[j][location];
                    board[j][location] = 0;
                    
                    //stack의 값과 동일하면 
                    if(!stack.isEmpty() && stack.peek()==target){
                        stack.pop();
                        answer+=2;
                    }else{
                        stack.add(target);
                    }

                }
            }
        }
        
        return answer;
    }
}