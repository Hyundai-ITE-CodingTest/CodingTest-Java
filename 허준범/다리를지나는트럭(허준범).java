import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int curr_length = 0; // 현재 다리에 올라간 트럭 수
        int curr_weight = 0; // 현재 다리에 올라간 트럭 무게
        Queue<Integer> bridge = new LinkedList<>(); // 현재 다리
        for(int i=0; i < bridge_length; i++) { // 다리길이만큼 큐에 0을 추가
            bridge.add(0);
        }
        int delay = 0; // 총 걸린 시간 
        int idx = 0; // 트럭 인덱스
        
        // 대기 트럭 다 처리하면 종료
        while(idx < truck_weights.length) {
            // 트럭 추가와 상관없이 계속 하나씩 빼고, 나간 값이 트럭이면 처리 
            int outBridge = bridge.remove();
            if(outBridge != 0) {
                curr_length--;
                curr_weight -= outBridge;
            }
            
            // 트럭 수와 다리가 견딜 수 있는 무게를 동시에 만족 시, 새로운 트럭 추가
            if(curr_length < bridge_length && (curr_weight + truck_weights[idx]) <= weight) {
                curr_length ++;
                curr_weight += truck_weights[idx];
                bridge.add(truck_weights[idx]);
                idx++;
            } else { // 아니면 0 추가
                bridge.add(0);
            }        
            delay++; // 시간 증가
        }
        
        // 남아있는 것들 처리
        while(!bridge.isEmpty()) {
            bridge.remove();
            delay++;
        }
        
        answer = delay;
        return answer;        
    }
}