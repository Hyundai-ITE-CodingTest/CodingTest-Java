package test.date1;
///https://programmers.co.kr/learn/courses/30/lessons/42583


//무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간
import java.util.*;

class Solution {
  public long solution(int bridge_length, int weight, int[] truck_weights) {
      //최초에 1초 소요
      long answer = bridge_length+1;
      
      // Deque<Integer> q = new ArrayDeque();
      Queue<Integer> onBridge = new LinkedList();
      Queue<Integer> watingCar = new LinkedList();
      int left_len= bridge_length;
      int left_weight = weight; 
      
      for(int i =0 ; i< truck_weights.length; i++){
          watingCar.add(truck_weights[i]);
      }
      
      while(true){
          //한대만 남으면 break;
          
          //올릴 수 있으면 올리기
          if(left_len-1>=0 && left_weight>=watingCar.peek()){
              int now_car=watingCar.poll();
              onBridge.add(now_car);
              left_len--;
              left_weight -=now_car;
              
              if(watingCar.size()==0){
              break;
              }
              answer++;
          }
              //못올리는 상황이면 0넣어주기
          else{
              onBridge.add(0);
              answer++;
          }
          //q가 꽉차면 내보내기
          if(onBridge.size()==bridge_length){
              int out = onBridge.poll();
              if(out>0){
                  left_len++;
                  left_weight +=out;
              }
          }
          
      }
      return answer;
  }
}

//무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간
//import java.util.*;

//class Solution {
//   public long solution(int bridge_length, int weight, int[] truck_weights) {
//       long answer = 1;
//       //최초에 1초 소요
//       Deque<Integer> q = new ArrayDeque();
//       Queue<Integer> q_on_bridge = new LinkedList();
//       Queue<Integer> q_on_bridge_start = new LinkedList();
//       int left_len= bridge_length;
//       int left_weight = weight; 
      
//       for(int i =0 ; i< truck_weights.length; i++){
//           q.add(truck_weights[i]);
//       }
//       while(!q.isEmpty()){
//           if(q_on_bridge.isEmpty()){
//               //빈 다리에 최대한 넣는경우 첫차는 다리길이만큼 시간소요 바로 연달아오는 차는 1초소요
//               int cnt =0;
//               int now_truck = q.poll();
//               // 한대 추가 => 가용무게 감소, 가용길이 감소
//               left_len--;
//               left_weight -=now_truck;
//               //다리위 트럭 큐에 값 추가
//               q_on_bridge.add(now_truck);
//               while(true){
//                   if(q.isEmpty()){
//                       break;
//                   }
//                   if(q.peek()<=weight && left_len-1>=0){
//                       cnt++;
                      
//                       int next_truck =q.poll();
//                         // 한대 추가 => 가용무게 감소, 가용길이 감소
//                        left_len--;
//                        left_weight-=next_truck;
//                        //다리위 트럭 큐에 값 추가
//                        q_on_bridge.add(next_truck);
                     
//                   }else{
//                       answer +=cnt+bridge_length;
//                       break;
//                   }
//               }
//               //다 올렸으면 이제 내보낸다.
//               if(!q_on_bridge.isEmpty()){
//                   int cnt2=length-q_on_bridge.size();
//               }
//               while(!q_on_bridge.isEmpty()){
//                   //한대 나감
//                   int now_truck =q_on_bridge.poll();
//                   //남은 길이, 가용 무게 늘려주기 
//                   left_len++;
//                   left_weight +=now_truck;
//                   if(q.peek()<=weight && left_len-1>=0){
//                        cnt2++;
//                        int next_truck =q.poll();
//                         // 한대 추가 => 가용무게 감소, 가용길이 감소
//                        left_len--;
//                        left_weight-=next_truck;
//                        //다리위 트럭 큐에 값 추가
//                        q_on_bridge_start.add(next_truck);    
//                   }
//               }
              
              
              
//           }
         
////             while(true){
////                 //한대 나감 ->
//// //                들어올수 있음 -> answer -= q_on_bridge.size();
//// //                못들어옴 -> 다음 차가 나가면 들어올 수 있는무게 = 이전에나간차 +지금나간차 
              
////             }
        
          
//           answer +=cnt+bridge_length;
          
//       }
      
      
      
      
//       return answer;
//   }
//}