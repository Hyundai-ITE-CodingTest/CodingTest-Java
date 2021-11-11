import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				//o1-o2 : 오름차순
				//o2-o1 : 내림차순
				return o1-o2;
			}
		});
        
        for(int scov : scoville){
            pq.add(scov);
        }
        
        while(pq.peek()<K && pq.size()>1){
            answer++;
            int item1 = pq.poll();
            int item2 = pq.poll();
            
            int newScov = item1 + (item2*2);
            pq.add(newScov);
        }
        
        if(pq.peek()<K){answer=-1;}
        
        return answer;
    }
}