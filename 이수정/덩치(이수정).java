package Olympiad;

import java.util.Scanner;

public class DunchiRank {
    public static void main(String[] args) {
        //사람의 덩치 -> (몸무게,키)
        //x > a y> b => a > b
        Scanner scan = new Scanner(System.in);
        int[][] info = new int[scan.nextInt()][2];
        for(int i = 0; i < info.length; i++){
            for(int j = 0; j < 2; j++){
                info[i][j] = scan.nextInt();
            }
        }

        for(int i = 0; i < info.length; i++){
            int rank = 1;
            for(int j = 0; j < info.length; j++){
                if(i == j) continue;
                else if(info[i][0] < info[j][0] && info[i][1] < info[j][1]){
                    rank++;
                }
            }
            System.out.print(rank + " ");
        }
    }
}
