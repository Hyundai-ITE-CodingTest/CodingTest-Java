import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        //행렬 만들기
        int[][] arr = new int[rows][columns];
        for(int i = 1; i <= rows; i ++){
            for(int j = 1; j <= columns; j++){
                arr[i-1][j-1] = (i-1) * columns + j;
            }
        } 
        for (int k = 0; k < queries.length; k++){
            //queries[0]-1 queries[1]-1 시작 좌표
            //queries[2]-1 queries[3]-1 마지막 좌표 
            int x1 = queries[k][0] - 1;
            int y1 = queries[k][1] - 1;
            int x2 = queries[k][2] - 1;
            int y2 = queries[k][3] - 1;
            
            answer[k] = graph(arr, x1, y1, x2, y2);
        }
        return answer;
    }
    public int graph(int[][] arr, int x1, int y1, int x2, int y2){
        //첫번째 값은 무조건 최솟값
        int temp = arr[x1][y1];
        int min = temp;
        //for문 방향성이 중요함
        //위
         for (int i = x1; i < x2; i++) {
            arr[i][y1] = arr[i + 1][y1];
            min = Math.min(min, arr[i][y1]);
        }
        //왼쪽 방향
        for (int i = y1; i < y2; i++) {
            arr[x2][i] = arr[x2][i + 1];
            min = Math.min(min, arr[x2][i]);
        }
        //아래
        for (int i = x2; i > x1; i--) {
            arr[i][y2] = arr[i - 1][y2];
            min = Math.min(min, arr[i][y2]);
        }
        //오른쪽
        for (int i = y2; i > y1+1; i--) {
            arr[x1][i] = arr[x1][i - 1];
            min = Math.min(min, arr[x1][i]);
        }

        arr[x1][y1+1] = temp;
        
        return min;
    }
}
