package Quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Quiz01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("자연수 N을 입력하세요");
        try{
            int n = scan.nextInt();
            for(int i = 0; i< n; i++){
                System.out.println("Hello MyCompany!");
            }}catch(InputMismatchException e){
                System.out.println("자연수가 아닙니다.");
            }
    }
}
