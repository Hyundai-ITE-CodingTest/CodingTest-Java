package codingtest;

public class StockPrice {

   public static void main(String[] args) {
      StockPriceSolution solution = new StockPriceSolution();
      int[] prices = {1, 2, 3, 2, 3};
      int[] answer = solution.solution(prices);
   }
}

class StockPriceSolution {
    public int[] solution(int[] prices) {
       int leng = prices.length;
        int[] answer = new int[leng];
        
        for(int i= 0; i < prices.length; i++) {
           for(int j = i+1; j < prices.length; j++) {
              if(prices[i] > prices[j]) {
                 answer[i] += 1;
                 break;
              }
              answer[i] += 1;
           }
        }
        for (int i : answer) {
         System.out.println(i);
      }
        
        return answer;
    }
}