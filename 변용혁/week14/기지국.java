package week14;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	static List<Point> home;
	static List<Point> aa;
	static List<Point> bb;
	static List<Point> cc;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());

		int T = Integer.parseInt(st.nextToken());
		int[] answer = new int[T]; // 정답배열

		for (int t = 0; t < T; t++) {
			home = new ArrayList<>();
			aa = new ArrayList<>();
			bb = new ArrayList<>();
			cc = new ArrayList<>();

			st = new StringTokenizer(sc.nextLine());
			int n = Integer.parseInt(st.nextToken());

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(sc.nextLine());

				for (int j = 0; j < n; j++) {

					char x = st.nextToken().charAt(0);
					if (x == 'H') {
						home.add(new Point(j, i));
					} else if (x == 'A') {
						aa.add(new Point(j, i));
					} else if (x == 'B') {
						bb.add(new Point(j, i));
					} else if (x == 'C') {
						cc.add(new Point(j, i));
					}
				}
			}

			// a b c 기지국마다 집 없애기
			for (Point a : aa) {
				removeHome(1, a, n);
			}
			for (Point b : bb) {
				removeHome(2, b, n);
			}
			for (Point c : cc) {
				removeHome(3, c, n);
			}
			
			answer[t] = home.size();
		}
		for (int t = 0; t < T; t++) {
			System.out.printf("#%d %d\n", t+1, answer[t]);
		}
	}

	public static void removeHome(int range, Point p, int n) {
		int cx = p.x;
		int cy = p.y;

		for (int dx = -range; dx <= range; dx++) {
			int nx = cx + dx;
			if (0 <= nx && nx < n) {
				home.remove(new Point(nx, cy));
			}
		}
		
		for (int dy = -range; dy <= range; dy++) {
			int ny = cy + dy;
			if (0 <= ny && ny < n) {
				home.remove(new Point(cx, ny));
			}
		}
	}
}
