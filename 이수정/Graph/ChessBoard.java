import java.util.Scanner;

public class ChessBoard {
    public static void main(String[] args) {

        // 1 단계: 지민이가 확인할 보드판의 크기를 입력 받는다
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        String[] arr = new String[N];
        scan.nextLine(); //nextInt 입력 버퍼 남아 있으니까 초기화

        // 2 단계: 주어진 보드판 색상 입력
        for (int i = 0; i < N; i++) {
            arr[i] = scan.nextLine();
        }

        int min = 64; //다 바꿀일은 없지만 8,8 기준
        int count;
        int end_r = N - 8; int end_c = M - 8;
        // 3 단계: 다시 칠해야 하는 최소 개수를 비교한다
        for (int i = 0; i <= end_r; i++) {
            for (int j = 0; j <= end_c; j++) {
                count = MinCount(arr, i, j);
                if(min > count) min = count;
            }
        }
        System.out.println(min);
    }
    //자른 범위에서 가장 적게 변경한 수를 찾는다.
    public static int MinCount(String arr[], int x, int y) {
        int count1 = 0; int count2 = 0;
        //보드가 8개로 자를 때 나올 수 있는 경우의 수는 2가지다
        String[] start_B = new String[8];
        for(int i =0; i< 8; i++){
            if(i == 0) {
                start_B[i] = "BWBWBWBW";
            }else {
                if (i % 2 == 0) {
                    start_B[i] = "BWBWBWBW";
                } else start_B[i] = "WBWBWBWB";
            }
        }
        String[] start_W = new String[8];
        for(int i =0; i< 8; i++){
            if(i == 0) {
                start_W[i] = "WBWBWBWB";
            }else {
                if (i % 2 == 0) {
                    start_W[i] = "WBWBWBWB";
                } else start_W[i] = "BWBWBWBW";
            }
        }
        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (arr[i].charAt(j) != start_B[i - x].charAt(j - y)) {
                    count1++; }
                if (arr[i].charAt(j) != start_W[i - x].charAt(j - y)) {
                    count2++; }
            }
        }
        if (count1 > count2) {
            return count2;
        }
        return count1;
    }
}




