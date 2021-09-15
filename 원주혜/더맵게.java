import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> foodQue = new PriorityQueue<Integer>();
		
		for (int i = 0; i < scoville.length; i++) {
			foodQue.add(scoville[i]);
		}
        
		int answer = 0;
        
		while(foodQue.size() > 1) {
			int first = foodQue.poll();
			int second = foodQue.poll();
			
			int nextFood = first + 2*second;
			foodQue.add(nextFood);
			
			++answer;
			
			if(foodQue.peek() >= K) {
				return answer;
			}
		}
		
		return -1;
    }
}
