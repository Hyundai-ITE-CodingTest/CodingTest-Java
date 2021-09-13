import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int s : scoville){
            q.offer(s);
        }
        
        while(q.peek()<K){
            if(q.size()==1){
                answer=-1;
                break;
            }
            int least = q.poll();
            int second = q.poll();
            q.offer(least + (second*2));
            answer++;
        }
        
        return answer;
    }
}
