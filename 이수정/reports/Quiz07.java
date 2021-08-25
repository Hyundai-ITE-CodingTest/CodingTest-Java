package Answer02;

import java.util.Scanner;

public class Quiz07 {
    public static void main(String[] args) {
        //1. 입력 받기 : 1) 사과 개수, 2) 사과 마다 점수 3) 장애물 정보1 4) 장애물 정보2
        Scanner scan = new Scanner(System.in);
        int total = 0;
        int N = scan.nextInt();
        int[] score = new int[N];
        for(int i = 0; i< N; i++){
            score[i] = scan.nextInt();
        }
        String s1 = scan.next();
        String[] first = s1.split("");
        String s2 = scan.next();
        String[] second = s2.split("");

        //2. 동일 열의 위치에 값이 "O"일 경우에만 score 배열 위치의 값 총합에 저장
        for(int i = 0; i< N; i++){
            if(first[i].equals("O") && second[i].equals("O"))
                total += score[i];
        }
        System.out.println("총 점수: \n" + total);
    }
}
