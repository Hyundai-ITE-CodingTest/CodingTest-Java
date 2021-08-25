package codingtest;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack; 

public class Truck {

   public static void main(String[] args) {
      Solution sl1 = new Solution();   
      int[] truck_weights = 
   //         {7,4,5,6};
   //         {10};
      {10,10,10,10,10,10,10,10,10,10};
   //      100   100   [10]   101
   //      int result = sl1.solution(2, 10, truck_weights);
   //      int result = sl1.solution(100, 100, truck_weights);
      int result = sl1.solution(100, 100, truck_weights);
      System.out.println(result);
   }

}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
       Deque<Integer> waitingQue = new ArrayDeque<>(); 
       Queue<Integer> signalQue = new LinkedList<>();
       
       // 초기화
       for (int i = 0; i < truck_weights.length; i++) {
          waitingQue.add(truck_weights[i]);
      }
       
       int time = 0;
       
       while(!waitingQue.isEmpty()) {
                   
          ++time;
          // 나가기
          if(signalQue.size() >= bridge_length) {
             int past = signalQue.poll();
             System.out.println("exit 1" + past + "time "+ time);
          }
          
          int curTruck = waitingQue.getFirst();
          
          //check weights
          int curSum = curTruck;
          for (Integer cur_truck : signalQue) {
             curSum += cur_truck;
         }
          
          //들어갈 때
         if(curSum <= weight ) {
            
            waitingQue.poll();
            signalQue.add(curTruck);

            continue;
         }
         //이동중
         signalQue.add(0);
       }
       
       int left = signalQue.size();
       //이동중
       while(signalQue.size() < bridge_length) {
          ++time;
          signalQue.add(0);
       }
       
       time += left;
      return time;
    }
}