import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int task : priorities){
            heap.offer(task);
        }
        
        System.out.println(heap);
        while(heap.size() > 0){
            for(int i = 0; i < priorities.length; i++){
                if(priorities[i] == heap.peek()){
                    answer++;
                    heap.poll();
                    if (i == location){
                        return answer;
                    }
                }
            }
        }

        return answer;
    }
}
