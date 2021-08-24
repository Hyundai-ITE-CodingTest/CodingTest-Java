import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sticker {
    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Testcase = Integer.parseInt(br.readLine());
        for(int i =0; i < Testcase; i++){
            int N = Integer.parseInt(br.readLine());
            int[][] arr= new int[2][N];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[0][j] = Integer.parseInt(st1.nextToken());
                arr[1][j] = Integer.parseInt(st2.nextToken());
            }
            //output
            System.out.println(MaxSticker(arr));
        }
    }
    public static int MaxSticker(int[][] arr){ //Math.max(,) 함수 활용
        int row = arr.length; int col = arr[0].length;
        int[][] dp = new int[row][col]; //배열값 더한 저장 배열
        //base case : 시작 지점에 따른 최소 대각선 범위
        dp[0][0] = arr[0][0];
        dp[1][0] = arr[1][0];
        dp[0][1] = arr[0][1] + arr[1][0];
        dp[1][1] = arr[1][1] + arr[0][0];
        //recursive case : 시작 위치와 반대 열, 대각선 이동 2가지
        for(int i = 2; i< col; i++){
            dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + arr[0][i];
            dp[1][i] = Math.max(dp[0][i-1],dp[0][i-2]) + arr[1][i];
            }
        return Math.max(dp[0][col-1],dp[1][col-1]);
    }
}
