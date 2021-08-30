
package boj;

// 블로그 참고

import java.io.*;

public class Boj_1003{

    static Integer[][] dp = new Integer[41][2];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            fibonacci(n);
            bw.write(dp[n][0] + " " + dp[n][1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static Integer[] fibonacci(int n){
        if(dp[n][0] == null || dp[n][1] == null){
            dp[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
            dp[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
        }

        return dp[n];
    }
}
