/*
출력 결과는 동일하지만, 백준에서 오답 결과를 받음
해결하기 위해 정수형이라는 조건에 맞춰 long 타입 변경 -> 해결X
랜선 길이가 자연수라는 조거 -> mid를 1로 시작 -> 해결X
*/
import java.util.Arrays;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int K = scan.nextInt();
        int N = scan.nextInt();
        int[] arr = new int[K];
        for(int i = 0; i < arr.length; i++){
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);
        long end = arr[0] /(N/arr.length);
        long start = arr[0] /((N/arr.length)+1);
        long mid = 1;
        while(start<=end){
            long count = 0;
            mid = (start + end)/2;
            for(int i = 0; i < arr.length; i++){
                count += arr[i] / mid;
            }
            if(count >= N) start = mid +1;
            else if(count < N) end = mid -1;
        }
        System.out.print(end);
    }
}

