import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<moves.length; i++){
            for(int j=0; j<board.length; j++){
                //0이 아닐 때
                if(board[j][moves[i]-1] != 0){
                    //현재 인형이 stack의 꼭대기의 값이랑 같다면
                    if(!stack.isEmpty() && stack.peek() == board[j][moves[i]-1]){
                        //stack에서 하나 빼주고 2개를 터뜨린다.
                        stack.pop();
                        answer +=2;
                    }
                    else{//현재 인형이 stack의 꼭대기의 값이랑 같지 않다면
                        //stack에 현재 인형을 추가한다.
                        stack.add(board[j][moves[i]-1]);
                    }
                    //인형을 뽑았으니 기존 위치를 0으로 바꿔준다.
                    board[j][moves[i]-1] = 0;
                    //탐색종료
                    break;
                } 
            }
        }
        return answer;
    }
}
