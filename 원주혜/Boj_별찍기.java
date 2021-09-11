import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static String[][] board;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int size = (N - 1) * 4 + 1;
		board = new String[size][size];
		
		int depth = 0;
		while (N > 0) {
			drawStars(N, depth);
			depth += 2;
			--N;
		}

		for (int i = 0; i < size; i++) {
			System.out.println(String.join("", board[i]));
		}
	}

	public static void drawStars(int N, int start) {
		int width = (N - 1) * 4 + 1;

		// 첫번째줄
		for (int i = 0; i < width; i++) {
			board[start + 0][start + i] = "*";
		}
		// 중간줄
		for (int j = 1; j < width - 1; j++) {
			board[start + j][start + 0] = "*";
			for (int i = 1; i < width - 1; i++) {
				board[start + j][start + i] = " ";
			}
			board[start + j][start + width - 1] = "*";
		}
		// 마지막줄
		for (int i = 0; i < width; i++) {
			board[start + width - 1][start + i] = "*";
		}
	}
}
