package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_9465{

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n+1];
            int[][] dp = new int[2][n+1];
            
            // 초기화
            for(int j = 0; j < 2; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 1; k < sticker[0].length; k++){
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];

            for(int q = 2; q < sticker[0].length; q++){
                dp[0][q] = Math.max(dp[1][q-1], dp[1][q-2]) + sticker[0][q];
                dp[1][q] = Math.max(dp[0][q-1], dp[0][q-2]) + sticker[1][q];
            }

            bw.write(Math.max(dp[0][n], dp[1][n]) + "\n");

        }

        bw.flush();
        bw.close();
        br.close();

    }
}
