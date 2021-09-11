package week07;

import java.util.*;

public class 네트워크 {
	
    public static int solution(int n, int[][] computers) {
        int answer = 1;
        int len = computers.length;
        boolean[] visit = new boolean[len];        
        
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        visit[0] = true;
        
        while(stack.size() > 0) {
        	int temp = stack.pop();
        	for(int i=0; i<len; i++) {
        		if(!visit[i] && computers[temp][i] == 1){//방문 안했고 연결 되어있으면
        			stack.push(i);
        			visit[i] = true;
        		}
        	}
        	
        	if(stack.size() == 0) { //스택이 비어있으면 (더이상 연결된 컴퓨터가 없으면)
        		for(int i=0; i<len; i++) {
        			if(!visit[i]) { //방문안한 컴퓨터를 넣어준다.
        				stack.push(i);
        				answer++;
        				break;
        			}
        		}
        	}
        	//스택이 비어있고 더이상 방문할 컴퓨터가 없으면 추가가 안되므로 while문 탈출
        }    
        
        return answer;
    }
    
    
    public static void main(String[] args) {
		System.out.println(solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
		System.out.println(solution(3, new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
	}
}
