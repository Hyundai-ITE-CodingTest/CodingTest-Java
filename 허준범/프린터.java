import java.util.*;
class Node {
    int prior;
    int idx;
    
    Node(int prior, int idx) {
        this.prior = prior;
        this.idx = idx;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Node> q = new LinkedList<>();
        
        for(int i=0; i < priorities.length; i++) {
            q.add(new Node(priorities[i], i));
        }
        int printNum = 0;
        while(!q.isEmpty()) {
            Node now = q.poll();
            boolean isExist = false;
            for(Node leaves : q) {
                if(now.prior < leaves.prior) {
                    // 중요도가 높은 문서가 한 개라도 존재한다면
                    isExist = true;
                    break;
                }
            }
            if(isExist) // 중요도 높은 문서 존재 시, 가장 마지막에 다시 넣기
                q.add(now); 
            else { // 아니라면, 출력
                printNum++; 
                if(now.idx == location) {// 찾는 거
                    return answer = printNum;
                }
            }
                
        }
        
        return answer;
    }
}