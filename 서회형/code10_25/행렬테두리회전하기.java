class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        // 행렬 선언과 값을 넣어줌
        int[][] arr = new int[rows][columns];
        int start = 1;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				arr[i][j] = start;
				start++;
			}
		}
        
        // 회전 목록 수행
        int x1, y1, x2, y2;
        for(int k = 0; k < queries.length; k++){
            //시작 좌표x
            x1 = queries[k][0] - 1;
            //시작 좌표y
            y1 = queries[k][1] - 1;
            //끝 좌표x
            x2 = queries[k][2] - 1;
            //끝 좌표y
            y2 = queries[k][3] - 1;
            
            // (x1,y1) 임시저장
            int x1y1_val = arr[x1][y1];
            // 최솟값
            int min_val = x1y1_val;     
            
            //회전 시작 시계방향으로 
            for(int i = x1; i < x2; i++){
                arr[i][y1] = arr[i + 1][y1];
                min_val = Math.min(min_val, arr[i][y1]);
            }
            
            for(int j = y1; j < y2; j++){
                arr[x2][j] = arr[x2][j + 1];
                min_val = Math.min(min_val, arr[x2][j]);
            }
           
            for(int i = x2; i > x1; i--){
                arr[i][y2] = arr[i - 1][y2];
                min_val = Math.min(min_val, arr[i][y2]);
            }
            
            for(int j = y2; j > y1 + 1; j--){
                arr[x1][j] = arr[x1][j - 1];
                min_val = Math.min(min_val, arr[x1][j]);
            }
            arr[x1][y1 + 1] = x1y1_val;
            
            // 가장 작은 숫자 배열에 담기
            answer[k] = min_val;
        }
        
        return answer;
    }
}