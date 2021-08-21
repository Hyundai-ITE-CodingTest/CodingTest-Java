import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(bf.readLine());
		int m = Integer.parseInt(bf.readLine());

		int[][] arr = new int[n][n];

		int number = n * n;
		int x = 0, y = 0; // 현재 위치
		int nx = 0, ny = 0; // 다음 위치
		int dx = 1, dy = 1; // +1 , -1
		boolean rowcol = true; // 행바꿀지, 열바꿀지
		// number의 행렬 인덱스 적어본 거를 아래 코드로 작성함
		while (number > 0) {
			arr[x][y] = number;

			if (rowcol) { // 행 바꿈
				nx = x + dx;
				ny = y;
				if (nx == 0 || nx == n - 1 || arr[nx][ny] != 0) {
					// 반전
					rowcol = !rowcol;
					dx *= -1;
				}
				if (arr[nx][ny] != 0) { // 만약 이미 방문한 곳이면 반대로 수행
					nx = x;
					ny = y + dy;
				}

			} else { // 열 바꿈
				nx = x;
				ny = y + dy;
				if (ny == 0 || ny == n - 1 || arr[nx][ny] != 0) {
					// 반전
					rowcol = !rowcol;
					dy *= -1;
				}
				if (arr[nx][ny] != 0) { // 만약 이미 방문한 곳이면 반대로 수행
					nx = x + dx;
					ny = y;
				}
			}
			x = nx;
			y = ny;
			number--;
		}

		// System.out.print로 출력하면 시간초과가 뜬다.
		// BufferedWriter(584ms)보다 StringBuilder(508ms)가 더 빠른듯?
		// "데이터 양이 많아지면 StringBuilder 보다 BufferedWriter가 빠르다"라고 합니다! (편한 거 써야지..)
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == m) {
					x = i + 1;
					y = j + 1;
				}
				sb.append(arr[i][j]).append(" ");
			}
			sb.append('\n');
		}
		sb.append(x).append(' ').append(y);
		System.out.println(sb);
	}
}
