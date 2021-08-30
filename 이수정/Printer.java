import java.util.*;
//큐는 인덱스 접근이 불가함.
class Solution {
    public int solution(int[] priorities, int location) {
        //location은 큐에 따라 움직이는 인덱스라고 생각
        int answer = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        for(int value : priorities){
            q.add(value); //값 저장
        }
        Arrays.sort(priorities); // 우선순위 정렬
        int size = priorities.length-1;
        
        while(!q.isEmpty()){
            Integer top = q.poll(); //맨위의 값
            
            if(top == priorities[size - answer]){
                answer++;
                location--;
                if(location<0)
                    break;
            }else{
                q.add(top); //다시 저장 1,3,2,2
                location--;//1
                if(location<0)
                    location = q.size()-1;
            }
        }
        return answer;
    }
}
