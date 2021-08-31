//투포인터를 활용한 알고리즘
//이중 for문을 사용하면 시간복잡도 제곱승으로 증가
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Sum_2number {
    public static void main(String[] args) throws IOException {
        //Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int X = Integer.parseInt(br.readLine());
        int count = 0;
        String[] arr = str.split(" ");
        //for문으로 타입변환이 귀찮아서 찾은 방법 => 기억하기 귀찮아서 또 쓸까 싶다.
        int[] num = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(num);

        int start = 0; int end = N -1; int sum = 0;
        while(start < end){
            sum = num[start] + num[end];
            if(sum == X) {
                count++;
            }
            if(sum <= X){//두수의 합이 찾으려는 값보다 작다면,
                start++;
            }else {
                end--;
            }
        }
        System.out.println(count);
    }
}
