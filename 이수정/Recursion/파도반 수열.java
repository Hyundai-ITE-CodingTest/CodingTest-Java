import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 파도반수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i ++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(fib(N));
        }
    }
    public static long fib(int N){
        //1, 1, 1, 2, 2, 3, 4, 5, 7, 9
        //f(n-3) + f(n-2) = f(n)
        long[] arr = new long[N]; //int로 받으니까 틀렸다고 함(왜?)

        for(int i = 0; i< N; i++){
            //base code
            if(i < 3){
                arr[i] = 1;
            }else { //
                arr[i] = arr[i-3] + arr[i-2];
            }
        }
        return arr[N-1];
    }

}
