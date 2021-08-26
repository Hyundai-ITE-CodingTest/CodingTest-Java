import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Card02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());//4
        Queue<Integer> q = new LinkedList<>();
        int count = 1;
        for(int i = 0; i < N; i++){//4 3 2 1
            q.add(count);
            count++;
        }
        while(!q.isEmpty()){
            if(q.size()==1){
                bw.write(""+ q.peek());
                break;
            }else{
                q.poll();
                q.add(q.peek());
                q.poll();
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
