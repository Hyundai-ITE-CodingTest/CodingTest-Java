package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_1913 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(bf.readLine());
        int number = Integer.parseInt(bf.readLine());

        int row = (n / 2);
        int col = (n / 2);

        int[][] answer = new int[n][n];
        String answerIndex = "";
        int way = 0; // 0:up, 1:right 2:down 3:left
        int count = 1;

        answer[row][col] = count;

        for(int i = 1; i < n; i++){
            for(int j = 0; j < 2; j++){
                for(int k = 0; k < i; k++){
                    switch(way){
                        case 0:
                            row--;
                            break;
                        case 1:
                            col++;
                            break;
                        case 2:
                            row++;
                            break;
                        case 3:
                            col--;
                            break;
                    }
                    count++;
                    answer[row][col] = count;
                }
                way++;
                way = way%4;
            }
        }

        for(int i = 0; i < n - 1; i++){
            row--;
            count++;
            answer[row][col] = count;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                bw.write(answer[i][j] + " ");
                if(answer[i][j] == number){
                    answerIndex = (i + 1) + " " + (j + 1);
                }
            }
            bw.newLine();
        }
        bw.write(answerIndex);

        bw.flush();
        bw.close();
        bf.close();
    }    
}
