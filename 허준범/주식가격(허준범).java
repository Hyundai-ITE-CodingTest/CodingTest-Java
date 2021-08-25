class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n]; // 결과 배열
        
        // 2중 for문으로 매 초 마다 ---> 다음 가격과 비교
        for(int i=0; i < n; i++) {
            int timeVal = 0; // 가격이 떨어지지 않은 시간
            for(int j=i+1; j < n; j++) {
                if(prices[i] <= prices[j])
                    timeVal++;
                else {
                    timeVal++;
                    break;
                }
                    
            }
            answer[i] = timeVal;
        }
        
        return answer;
    }
}