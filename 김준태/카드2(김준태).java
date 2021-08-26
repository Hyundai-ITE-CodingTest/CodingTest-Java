import java.util.LinkedList;
import java.util.Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Boj_2164 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Queue<Integer> qu = new LinkedList<>();

        for (int num = 1; num <= n; num++){
            qu.offer(num);
        }
        boolean flag = false;
        while(qu.size() > 1){
            flag = !flag;
            if (flag){
                qu.poll();
            } else {
                qu.offer(qu.peek());
                qu.remove();
            }
        }
        System.out.println(qu.peek());
    }
}
