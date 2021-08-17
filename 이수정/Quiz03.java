package Quiz;

import java.util.Scanner;

public class Quiz03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] str;
        str = input.split(",");
        int num = 1;
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(str[i]);
            num *= arr[i];
        }
        System.out.println("입력받은 세 정수의 곱은: " + num);
        String s = Integer.toString(num);
        char ch;
        int[] count = new int[10];
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            count[ch - '0']++;
        }
        for(int i = 0; i < 10; i++){
            System.out.println(count[i]);
        }
    }
}

