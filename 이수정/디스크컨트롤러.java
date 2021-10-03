import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        //람다식
        //요청 시간 
	Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
	//소요 시간
	PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int point = 0; //디스크 요청 시점 저장
        int time = 0; // 디스크 종료 작업 저장 
        int count = 0;
        
        while (count < jobs.length) {
            while (point < jobs.length && jobs[point][0] <= time) {
                pq.add(jobs[point++]);
            }//정렬된 순으로 큐에 저장
            if (pq.isEmpty()) { // 모든 요소를 확인할 때 까지
                time = jobs[point][0];
            } else {
                int[] tmp = pq.poll(); //작업 저장후 삭제
                //앞에 걸린 시간 + 내가 소요되는 시간 - 시작한 시점
                answer += tmp[1] + time - tmp[0];
                time += tmp[1];
                count++;
            }
        }
        return answer / jobs.length;
    }
}
