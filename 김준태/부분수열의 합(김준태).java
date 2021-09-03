package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_1182 {
    // 블로그 참고
    static int n, s, count = 0;
    static int[] numbers;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        numbers = new int[n];
        for (int i=0; i<numbers.length; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if(s==0){
            count--;
            bw.write(count+"");
        } else{
            bw.write(count+"");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int v , int su){
        if(v==n){
            if(su == s){
                count++;
            }
            return;
        }

        dfs(v+1, su+numbers[v]);
        dfs(v+1, su);
    }
}
