import java.util.*;
import java.io.*;

class Solution {
	static int N;

	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		N = board.length;

		Stack<Integer> stack = new Stack<Integer>();

		for (int m : moves) {
			int item = getTopItem(board, m - 1);

			if (item != -1) {
				if (!stack.isEmpty() && stack.peek() == item) {
					answer += 2;
					stack.pop();
				}

				else {
					stack.push(item);
				}

				// printMap(board);
			}
		}

		return answer;
	}

	// n번째 위치의 최상단 아이템을 반환한다.
	public int getTopItem(int[][] board, int no) {
		for (int i = 0; i < N; i++) {
			if (board[i][no] != 0) {
				int result = board[i][no];
				board[i][no] = 0;
				return result;
			}
		}

		// 아무 것도 없는 곳에서는 -1을 반환한다.
		return -1;
	}

	public void printMap(int[][] board) {
		System.out.println();

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				System.out.printf("%d ", board[y][x]);
			}
			System.out.println();
		}
	}
}