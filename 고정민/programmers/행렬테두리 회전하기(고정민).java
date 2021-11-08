class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows+1][columns+1];
        int var=1;
        int[] answer = new int[queries.length];

        //map만들기
        for(int i=1; i<=rows; i++) {
            for(int j=1; j<=columns; j++) {
                map[i][j] = var++;
            }
        }

        for(int i=0; i<queries.length; i++) {
            //y1 queries[i][0], x1 queries[i][1] 왼쪽 상단 좌표
            //y1 queries[i][0], x2 queries[i][3] 오른쪽 상단 좌표
            //y2 queries[i][2], x2 queries[i][3] 오른쪽 하단 좌표
            //y2 queries[i][2], x1 queries[i][1] 왼쪽 하단 좌표 
            int y1 = queries[i][0];
            int x1 = queries[i][1];
            int y2 = queries[i][2];
            int x2 = queries[i][3];

            int temp = map[y1][x1]; //시작좌표 임시저장
            int min = 10000;

            //오른쪽으로
            for(int j=x1; j<x2; j++) {
                int temp2 = map[y1][j+1];
                map[y1][j+1] = temp;
                temp = temp2;
                min = Math.min(min, temp);
            }
            //아래쪽으로
            for(int j=y1; j<y2; j++) {
                int temp2 = map[j+1][x2];
                map[j+1][x2] = temp;
                temp = temp2;
                min = Math.min(min, temp);
            }
            //왼쪽으로
            for(int j=x2; j>x1; j--) {
                int temp2 = map[y2][j-1];
                map[y2][j-1] = temp;
                temp = temp2;
                min = Math.min(min, temp);
            }
            //위쪽으로
            for(int j=y2; j>y1; j--) {
                int temp2 = map[j-1][x1];
                map[j-1][x1] = temp;
                temp = temp2;
                min = Math.min(min, temp);
            }

            answer[i] = min;
        }
        return answer;
    }
}
