/*
인덱스 접근이 불가능하 큐를 활용하지 않았다면 더 쉬운 접근이 될듯 
*/
/*
import java.util.LinkedList;
import java.util.Queue;

public class QueuePrinter {
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        int find = priorities[location]; //3
        int answer = 0;
        Queue<Integer> q = new LinkedList();
        for(int val : priorities){
            q.add(val); //2,1,3,2
        }
        answer = 0;
        for(int i = 1; i< priorities.length; i++){
            if(find < q.peek() || find == q.peek()){ // 1 1
                answer++;
            }else{
                answer = answer;
            }
            q.poll();
        }
        System.out.println(answer);
    }
}
*/
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int[][] arr = new int[priorities.length][priorities.length];
        for(int i = 0; i < priorities.length; i++){
            arr[i][0] = i;
            arr[i][1] = priorities[i];
        }
        //숫자가 클수록 우선순위가 높음(둘다 가능)
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        // PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
        //     @Override
        //     public int compare(Integer o1, Integer o2){
        //         if(o1 == o2){
        //             return o1 - o2;
        //         }
        //         return o2 - o1;
        //     }
        // });
        //큐에 데이터를 다 넣은 다음
        for(int i = 0; i < priorities.length; i++){
            queue.add(priorities[i]);
        }
        while(!queue.isEmpty()){//하나씩 뺴면서, 빈큐가 될떄 까지
            for(int i = 0; i < priorities.length; i++){
                if(priorities[i] == queue.peek()){ //대기 목록의 값과 큐에 맨 앞의 값이 동일할 때 까지
                    if(location == i){ //찾으려는 값과 인덱스 위치가 동일하면 
                        return answer+1; // 몇번쨰 인지, 탐색 종료
                    }
                    answer++;
                    queue.poll();
                }
            }
        }
        
        //locaiont은 0부터 시작함
        return answer;
    }
}
