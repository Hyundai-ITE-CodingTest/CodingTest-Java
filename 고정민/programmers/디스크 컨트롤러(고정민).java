/*순서 : 현재 작업의 소요시간과 다음의 요청되는 시점의 차이가 작은 값*/
import java.util.*;

class Solution {
    public class Disk{
        int occasion;
        int time;
        public Disk(int occasion, int time){
            this.occasion = occasion;
            this.time = time;
        }
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // 요청 시점 오름차순
        Arrays.sort(jobs, ((o1, o2)->o1[0]-o2[0]));          
        // 처리 시간 오름차순
        PriorityQueue<Disk> pq = new PriorityQueue<>(new Comparator<Disk>(){
            @Override
            public int compare(Disk o1, Disk o2){
                return o1.time-o2.time;
            }
        });
        
        int count=0;
        int idx = 0;
        int now = jobs[0][0]; //첫 번째 요청 시점
        
        while(count<jobs.length){
            //요청이 끝나기 전에 또다른 요청이 들어온 작업을 작업시간이 짧은 순서대로 큐에 넣는다.
            //pq에 넣어주는 조건은 현재 시간보다 작거나 같고 idx가 jobs의 길이보다 작을 동안
            while(idx<jobs.length && now >= jobs[idx][0]){
                pq.add(new Disk(jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            if(pq.isEmpty()){ //pq가 비어있다는 건 작업 끝날 동안 요청이 안들어왔다는 거니까
                now = jobs[idx][0];
            }else{ //pq가 비어있지 않으면 계산 
                answer +=  (now-pq.peek().occasion)+pq.peek().time;
                now += pq.peek().time;
                pq.poll();
                count++;
            }
        }
        
        return answer/jobs.length;
    }
}
