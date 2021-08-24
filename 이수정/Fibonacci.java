import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci {
    static int count0;
    static int count1;
    static int preNext;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];
        for(int i = 0; i< T; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0; i< T; i++){
            fibo(arr[i]);
            System.out.printf(count0 + " " + count1);
            System.out.println();
        }

    }
    public static void fibo(int N){
        //f(0)일 경우 0 => 1,0 //f(1)일 경우 1 => 0,1
        //f(2)=> f(1)+f(0) 일 경우 1,1
        //f(3)=> f(2)+f(1)=> f(0)+f(1)+ f(1) 일 경우 1,2
        //f(4)=> f(3) + f(2) => f(2)+f(1) + f(1)+f(0) => f(1)+f(0)+f(1)+f(1)+f(0)
        //base code : 0, 1
        count0 = 1;
        count1 = 0;
        preNext = 1;
        for(int i =0; i< N; i++){
            count0 = count1;
            count1 = preNext;
            preNext = count0 + count1;
        }
    }
}

