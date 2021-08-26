package Quiz;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Quiz02 {
    public static void main(String[] args) {
        int[] arr = new int[7]; int sum =0;
        ArrayList odd = new ArrayList();
        Scanner scan = new Scanner(System.in);
        System.out.println("7개의 자연수를 입력하세요(,명시)");
        String input = scan.nextLine();
        String[] str;
        str = input.split(",");
        for(int i = 0; i < 7; i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        for(int i = 0; i < 7; i++){
            if(arr[i] % 2 != 0){
                sum += arr[i];
                odd.add(arr[i]);
            }
        }
        if(odd.size() > 0){
            System.out.println("홀수인 자연수의 합: "+ sum);
            System.out.println("홀수인 자연수의 최솟값: "+ Collections.min(odd));
        }else System.out.println(-1);
    }
}
