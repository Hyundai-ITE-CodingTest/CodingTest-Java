package code09_10;

import java.awt.Point;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Queue<Point> q = new LinkedList<Point>();
		Queue<Point> q2 = new LinkedList<Point>();
		// 가로 칸의 수(배열에서 열에 해당)
		int M = input.nextInt();
		// 세로 칸의 수(배열에서 행에 해당)
		int N = input.nextInt();
		boolean done = true;
		// 방문했는지 여부 확인해주는 boolean 배열
		boolean[][] visited = new boolean[N][M];

		// 익지 않은 토마토의 갯수
		int zeroCount = 0;
		// 일수
		int count = 0;

		int[][] tomato = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tomato[i][j] = input.nextInt();
				if (tomato[i][j] == 0) {
					zeroCount++;
				}
				if (tomato[i][j] == 1) {
					q.offer(new Point(i, j));
				}
			}
		}
		// 토마토 개수가 하나라도 있다면 day count을 1감소시켜야 정상적인 값이 나옴
		Loop1: for (int i = 0; i < N; i++) {
			Loop2: for (int j = 0; j < M; j++) {
				if (tomato[i][j] == 1) {
					count--;
					break Loop1;
				}
			}
		}
		// 입력했을 때부터 다 익어있는 상태라면 0를 출력
		if (zeroCount == 0) {
			System.out.println("0");
		} else {
			//zeroCount 초기화
			zeroCount = 0;
			while (done) {

				// 좌
				if (q.peek().x - 1 >= 0) {
					if (tomato[q.peek().x - 1][q.peek().y] != -1) {
						if (tomato[q.peek().x - 1][q.peek().y] == 0 && visited[q.peek().x - 1][q.peek().y] == false) {
							tomato[q.peek().x - 1][q.peek().y] = 1;
							visited[q.peek().x - 1][q.peek().y] = true;
							q2.offer(new Point(q.peek().x - 1, q.peek().y));
						}
					}
				}
				// 상
				if (q.peek().y + 1 < M) {
					if (tomato[q.peek().x][q.peek().y + 1] != -1) {
						if (tomato[q.peek().x][q.peek().y + 1] == 0 && visited[q.peek().x][q.peek().y + 1] == false) {
							tomato[q.peek().x][q.peek().y + 1] = 1;
							visited[q.peek().x][q.peek().y + 1] = true;
							q2.offer(new Point(q.peek().x, q.peek().y + 1));
						}
					}
				}
				// 우
				if (q.peek().x + 1 < N) {
					if (tomato[q.peek().x + 1][q.peek().y] != -1) {
						if (tomato[q.peek().x + 1][q.peek().y] == 0 && visited[q.peek().x + 1][q.peek().y] == false) {
							tomato[q.peek().x + 1][q.peek().y] = 1;
							visited[q.peek().x + 1][q.peek().y] = true;
							q2.offer(new Point(q.peek().x + 1, q.peek().y));
						}
					}
				}
				// 하
				if (q.peek().y - 1 >= 0) {
					if (tomato[q.peek().x][q.peek().y - 1] != -1) {
						if (tomato[q.peek().x][q.peek().y - 1] == 0 && visited[q.peek().x][q.peek().y - 1] == false) {
							tomato[q.peek().x][q.peek().y - 1] = 1;
							visited[q.peek().x][q.peek().y - 1] = true;
							q2.offer(new Point(q.peek().x, q.peek().y - 1));
						}
					}
				}
				q.remove();
				if (q.isEmpty()) {
					count++;
					q.addAll(q2);
					q2.clear();
				}

				if (q.isEmpty() && q2.isEmpty()) {

					done = false;

				}

			}
			// 아직도 익지 않은 토마토가 있다면 zeroCount 증가
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (tomato[i][j] == 0) {
						zeroCount++;
					}
				}
			}
			if (zeroCount > 0) {
				System.out.println("-1");
			} else {
				System.out.println(count);
			}
			
		}
		
					

	}
}
