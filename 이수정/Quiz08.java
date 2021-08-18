package Answer02;

import java.util.ArrayList;
import java.util.Scanner;

public class Quiz08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(); // 암기할 수 있는 수
        int M = scan.nextInt(); // 단어 수
        String[] str = new String[M];
        int time = 0;
        //String[] str = s.split(" ");
        for(int i = 0; i < M; i++){
            str[i] = scan.next();
        }
        ArrayList<String> list = new ArrayList<>();
        //n = 3 m = 5 { hello, hanwha, hi, ok, hello }
        for(int i =0; i < M; i++){//0~9
            if(N != 0){//3 2 1 // 처음 값 받기
                list.add(str[i]); //{hello, hanwha, hi}
                time += 3;
                N--;//2 1 0
            } else{// 머리에 자리가 꽉참. //{ok, hello}
                    if(list.contains(str[i]) == true){// 알고있는 정보가 들어올 때
                        time += 1;
                        String know = "";
                        know = str[i];
                        list.remove(know);
                        list.add(know);
                }else{//모르는 정보가 들어올 때,
                        time += 3;
                        String find = list.get(0);
                        for (String word : list) {
                            if (word.length() < find.length()) {
                                find = word;
                            }
                        }
                        list.remove(find); //가진 정보중 가장 짧은 단어 값 삭제
                        list.add(str[i]);
                }
            }
        }
        System.out.println(time);
    }
}