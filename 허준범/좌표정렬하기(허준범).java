import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

class Point {
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	int x, y;
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());

		ArrayList<Point> points = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points.add(new Point(x, y));
		}

		points.sort(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.x < o2.x) {
					return -1;
				} else if (o1.x > o2.x) {
					return 1;
				} else {
					if (o1.y < o2.y) {
						return -1;
					} else {
						return 1;
					}
				}
			}
		});

		for (Point p : points) {
			sb.append(p.x).append(' ').append(p.y).append('\n');
		}

		System.out.println(sb);
	}
}
