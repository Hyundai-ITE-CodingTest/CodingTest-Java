/*
백준에서 Buffered 사용시 정답 결과를 받지 못했는데 scanner 변경시 성공
*/

import java.util.Arrays;
import java.util.Scanner;

public class Findsu_scanner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] n_arr = new int[N];
        for(int i = 0; i< N; i++){
            n_arr[i] = scan.nextInt();
        }
        Arrays.sort(n_arr);
        int M = scan.nextInt();
        int[] m_arr = new int[M];
        for(int i = 0; i< M; i++){
            m_arr[i] = scan.nextInt();
        }
        for (int i =0; i<M; i++){
            System.out.println(BinarySearch(n_arr,m_arr[i]));
        }
    }
    public static int BinarySearch(int[] n, int find) {
        int start = 0;
        int end = n.length-1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (find == n[mid]) {
                return 1;
            } else if (find < n[mid]) {
                end = mid-1;
            } else if (find > n[mid]) {
                start = mid+1;
            }
        }
        return 0;
    }
}
