package Answer02;

import java.util.Scanner;

public class Quiz06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input1 = scan.nextInt();
        System.out.println("시작수: " + input1);
        int input2 = scan.nextInt();
        System.out.println("끝수: "+ input2);
        int input3 = scan.nextInt();
        System.out.println("배수: "+ input3);
        int sum = 0;
        for(int i = input1; i <= input2; i++){
            if(i % 7 ==0)
                sum += i;
        }
        System.out.println("배수의 합: "+ sum);
    }
}
