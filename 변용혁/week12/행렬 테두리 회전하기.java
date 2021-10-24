class Solution {
  static int[][] matrix;

	public int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		matrix = new int[rows][columns];
		int num = 1;

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				matrix[r][c] = num;
				num++;
			}
		}
		for (int i = 0; i < queries.length; i++) {
			answer[i] = spin(queries[i]);
		}

		return answer;
	}

	public int spin(int[] querie) {
		int y1 = querie[0] - 1;
		int x1 = querie[1] - 1;
		int y2 = querie[2] - 1;
		int x2 = querie[3] - 1;

		int temp = matrix[y1][x1];
		int min = temp;

		//반시계 방향으로 돌면서 앞에값을 지금 위치에 넣기
		for (int i = y1; i < y2; i++) { 
			matrix[i][x1] = matrix[i + 1][x1];
			if (min > matrix[i][x1])
				min = matrix[i][x1];
		}
		for (int i = x1; i < x2; i++) {
			matrix[y2][i] = matrix[y2][i + 1];
			if (min > matrix[y2][i])
				min = matrix[y2][i];
		}
		for (int i = y2; i > y1; i--) {
			matrix[i][x2] = matrix[i - 1][x2];
			if (min > matrix[i][x2])
				min = matrix[i][x2];
		}
		for (int i = x2; i > x1; i--) {
			matrix[y1][i] = matrix[y1][i - 1];
			if (min > matrix[y1][i])
				min = matrix[y1][i];
		}
		matrix[y1][x1 + 1] = temp;

		return min;
	}
}
