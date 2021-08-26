import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        int sum = 0;
        
        for(int truck:truck_weights){
            while(true){
                if(q.isEmpty()){
                    q.offer(truck);
                    sum += truck;
                    answer++;
                    break;
                }
                if(q.size() == bridge_length){
                    sum -= q.poll();
                }else{
                  if(sum + truck <= weight){
                    q.offer(truck);
                    sum+=truck;
                    answer++;
                    break;
                  }else{
                    q.offer(0); //sum -= q.poll();을 왜했을까..
                    answer++;
                }
               }
            }
        }
        return answer+bridge_length;
    }
}
