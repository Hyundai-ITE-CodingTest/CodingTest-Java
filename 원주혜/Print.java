package codingtest;

import java.util.ArrayList;
import java.util.LinkedList; 

public class Print {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] prioties = 
				//{2,1,3,2};
			{1, 1, 9, 1, 1, 1};
		sol.solution(prioties, 0);
	}
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        //Array => 링크드리스트
        LinkedList<Integer> queue = new LinkedList<>();
        LinkedList<Integer> order = new LinkedList<>();
        
        ArrayList<Integer> printed = new ArrayList<>();
        
        
        for(int i=0; i < priorities.length; i++) {
        	queue.add(priorities[i]);
        	order.add(i);
        }
        
        
        while(queue.size() > 0) {
        	int first = queue.poll(); 
        	int firstIdx = order.poll();
        	
        	//탐색
        	int index = 0;
        	while(queue.size() > index && first >= queue.get(index)) {
        		++index;
        	}
        	
        	//탐색 
        	if(index >= queue.size()) {
        		printed.add(firstIdx);
        		continue;
        	}
        	
        	queue.add(first);
        	order.add(firstIdx);
        	
        }
        answer = printed.indexOf(location) + 1;
        System.out.println("answer " + answer);
        return answer;
    }
}