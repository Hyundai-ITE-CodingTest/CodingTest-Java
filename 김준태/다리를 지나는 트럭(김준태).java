import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        
        Queue<Integer> bridge = new LinkedList<>();
            
        // 다리위 올라가는 시간 1초, 1초마다 1길이만큼 이동한다.
        // 다리 위 차들의 무게의합은 전체무게 weight를 넘어서는 안된다.
        // 모든 트럭이 다리를 건너려면 최소 몇초가 걸리는지 - answer
        // 다리위에 올라간 순간부터 bridge_length시간초 만큼 뒤에 알아서 내려간다.
        int complete = 0; // 다리를 건넌 트럭 수
        int totalWeight = 0; // 다리 위 트럭의 무게
        int index = 0; 
        int[] position = new int[truck_weights.length];
        
        while(complete < truck_weights.length){
            answer++;
            if(index < truck_weights.length){
                if(weight >= totalWeight + truck_weights[index] && bridge_length >= bridge.size()){
                    bridge.offer(truck_weights[index]);
                    totalWeight += truck_weights[index];
                    index++;
                }
            }
            for(int i = complete; i < index; i++){
                position[i]++;
                if(position[i] >= bridge_length){
                    bridge.poll();
                    complete++;
                    totalWeight -= truck_weights[i];
                }
            }
        }
        return answer;
    }
}
