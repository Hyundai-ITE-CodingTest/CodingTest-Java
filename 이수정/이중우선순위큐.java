import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        answer = new int[2];
        PriorityQueue<Integer> small_pqueue = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o1 - o2;
            }
        });
        PriorityQueue<Integer> large_pqueue = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2 - o1;
            }
        });

        for(String s : operations){
            String[] arr = s.split(" "); 
            int value = Integer.parseInt(arr[1]);
            //System.out.println(arr[0] +" "+ value);
            if(arr[0].equals("D") && small_pqueue.size() == 0){ //빈 큐에서 삭제하라는 연산일 때
                continue;
            }
            else if(arr[0].equals("I")){// 값 추가 두군데 넣기
                small_pqueue.add(value);
                large_pqueue.add(value);
            }
            else{ //삭제 
                if(value == 1){ //최댓값을 제거
                    int large = large_pqueue.poll(); //변수로 지정하고 제거
                    small_pqueue.remove(large); //small 큐에서 large 값 제거
                }
                else { //최솟값을 제거
                    int small = small_pqueue.poll();
                    large_pqueue.remove(small);
                }
            }
        }
        if(small_pqueue.size() > 0){
            answer[0] = large_pqueue.peek();
            answer[1] = small_pqueue.peek();   
        }
        return answer;
    }
}
