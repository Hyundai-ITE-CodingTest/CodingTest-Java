import java.util.*;
import java.lang.*;
import java.io.*;
//https://velog.io/@ajufresh/%EB%93%B1%EA%B5%A3%EA%B8%B8
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] board = new int[m+1][n+1];
        for(int i=0; i<puddles.length; i++){
            board[puddles[i][0]][puddles[i][1]]=-1;
        }
        board[1][0]=1;
        //i는 1,1 2,2 3,3, n,n 의 n
         for(int i=1; i<=Math.min(m,n); i++){

             for(int j=i; j<=m; j++){
                 if(board[j][i]!=0)
                 {
                    continue;        
                 }else{
                    int left=0;
                    int top =0;
                    if(board[j-1][i]!=-1){
                        left = board[j-1][i];
                    }
                    if(board[j][i-1]!=-1){
                       top  =board[j][i-1];;
                    }
                    board[j][i]=(left+top)%1000000007;
                 }
             }
              for(int j=i; j<=n; j++){
                if(board[i][j]!=0)
                 {
                    continue;        
                 }else{
                    int left=0;
                    int top =0;
                    if(board[i-1][j]!=-1){
                        left = board[i-1][j];
                    }
                    if(board[i][j-1]!=-1){
                       top  =board[i][j-1];;
                    }
                    board[i][j]=(left+top)%1000000007;
                 }
              }
         }

//         for(int i=0;i<=n;i++){
//             for(int j=0;j<=m;j++){
//                 System.out.print(board[j][i]+" ");
//             }
//             System.out.println(" ");
//         }

        int answer = board[m][n];
        return answer;
    }
}
