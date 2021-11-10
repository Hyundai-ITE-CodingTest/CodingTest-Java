import java.util.*;
class Solution {
    static class Rate{
        int idx;
        double rate;
        public Rate(int idx, double rate){
            this.idx = idx;
            this.rate = rate;
        }
    }
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        List<Rate> array = new ArrayList<>();
        //1. 단계별로 계산하기 (i:단계)
        for(int i=1; i<=N; i++){
            //2. 각 단계보다 높은 값을 갖고 있는 stages의 원소(j) 개수를 구해야 함
            double cnt=0;
            double stage=0;
            for(int j=0; j<stages.length;j++){
                if(i<=stages[j]) cnt++;
                if(i==stages[j]) stage++;
            }
            double result = stage/cnt;
            if(Double.isInfinite(result) || Double.isNaN(result)) result = 0.0;
            
            array.add(new Rate(i, result));
        }
        Collections.sort(array, ((o1, o2) -> Double.compare(o2.rate, o1.rate)));
        
        for(int i=0; i<answer.length; i++){
            answer[i] = array.get(i).idx;
        }
        return answer;
    }
    
    
}
