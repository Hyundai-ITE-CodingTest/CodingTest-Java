/*
인덱스 접근이 불가능하 큐를 활용하지 않았다면 더 쉬운 접근이 될듯 
*/
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
