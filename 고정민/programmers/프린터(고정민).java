import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int p : priorities){
            q.offer(p);
        }
        Arrays.sort(priorities);
        int len = priorities.length-1;
        
        while(!q.isEmpty()){
            int curr = q.poll();
            if(curr == priorities[len-ans]){ //꺼낸 수 == 최댓값 
                ans+=1; //출력횟수증가
                if(location==0) break; //내가 요청한 문서면 반복문 빠져나가서 return
                else location--; //요청한 문서가 아니면 loc--
            }else{ //꺼낸 수 != 최댓값
                q.offer(curr); //뒤로 보냄
                location--;
                if(location<0)  location = q.size()-1; // location이 음수라는 것은 내가 요청한 문서가 큐의 맨 뒤로 간 것
            }
        }
        return ans;
    }
}
