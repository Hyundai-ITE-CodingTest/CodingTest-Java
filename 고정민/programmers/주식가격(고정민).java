class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0 ; i<prices.length; i++){
            answer[i] = 0;
            for(int j =i+1; j<prices.length;j++){
                    answer[i]+=1;
                    if(prices[i]>prices[j]) break;
            }
        }
        return answer;
    }
}
