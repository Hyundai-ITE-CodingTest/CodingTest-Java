import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[][] board;
	
	static Point[] bluetetro = {new Point(0,0), new Point(0,1), new Point(0,2), new Point(0,3)};
	static Point[] yellowtetro = {new Point(0,0), new Point(0, 1), new Point(1,1), new Point(1, 0)};
	static Point[] orangetetro = {new Point(-2,0), new Point(-1, 0), new Point(0,0), new Point(0, 1)};
	static Point[] greentetro = {new Point(-1,0), new Point(0, 0), new Point(0,1), new Point(1, 1)};
	static Point[] pinktetro = {new Point(-1,0), new Point(0, 0), new Point(0,1), new Point(1, 0)};
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		board = new int[N][M];
		
		
		//board 그리기
		for(int i=0; i < N; i++) {
			board[i] = Arrays.asList((br.readLine()).split(" ")).stream().mapToInt(Integer::parseInt).toArray();		
		}
		
		rotate90(bluetetro);
		
		int max = Integer.MIN_VALUE;
		
		//blue
		for(int y=0; y < N; y++) {
			for(int x=0; x < M; x++) {
				int result = calSum(y, x, bluetetro);
				max = Math.max(max, result);
			}
		}
		rotate90(bluetetro);
		for(int y=0; y < N; y++) {
			for(int x=0; x < M; x++) {
				int result = calSum(y, x, bluetetro);
				max = Math.max(max, result);
			}
		}
		
		//yellow 
		//대칭과 회전이 똑같다
		for(int y=0; y < N; y++) {
			for(int x=0; x < M; x++) {
				int result = calSum(y, x, yellowtetro);
				max = Math.max(max, result);
			}
		}
		
		
		//orange
		for(int i=0; i < 4; i++) {
			for(int y=0; y < N; y++) {
				for(int x=0; x < M; x++) {
					int result = calSum(y, x, orangetetro);
					max = Math.max(max, result);
				}
			}
			rotate90(orangetetro);
		}
		//대칭
		symmetry(orangetetro);
		
		for(int i=0; i < 4; i++) {
			for(int y=0; y < N; y++) {
				for(int x=0; x < M; x++) {
					int result = calSum(y, x, orangetetro);
					max = Math.max(max, result);
				}
			}
			rotate90(orangetetro);
		}
		
		
		//green
		for(int i = 0; i < 2; i++) {
			for(int y=0; y < N; y++) {
				for(int x=0; x < M; x++) {
					int result = calSum(y, x, greentetro);
					max = Math.max(max, result);
				}
			}
			rotate90(greentetro);
		}
		symmetry(greentetro);
		
		for(int i = 0; i < 2; i++) {
			
			for(int y=0; y < N; y++) {
				for(int x=0; x < M; x++) {
					int result = calSum(y, x, greentetro);
					max = Math.max(max, result);
				}
			}
			rotate90(greentetro);
		}
		
		//pink
		for(int i =0; i < 4; i++) {
			for(int y=0; y < N; y++) {
				for(int x=0; x < M; x++) {
					int result = calSum(y, x, pinktetro);
					max = Math.max(max, result);
				}
			}
			rotate90(pinktetro);
		}
		System.out.println(max);
		
	}
	
	public static int calSum(int y, int x, Point[] tetro) {
		int sum = 0;
		for (Point point : tetro) {
			int curY = point.y + y;
			int curX = point.x + x;
			if(curY >= N || curY < 0 || curX >= M || curX < 0) {
				continue;
			}
			sum += board[curY][curX];
		}
		
		return sum;
	}
	
	public static void rotate90(Point[] tetro) {
		for (Point point : tetro) {
			int orgy = point.y;
			int orgx = point.x;
			point.y = orgx;
			point.x = -orgy;
		}
	}
	
	public static void symmetry(Point[] tetro) {
		for(Point point : tetro) {
			int orgy = point.y;
			int orgx = point.x;
			point.y = orgy;
			point.x = -orgx;
		}
	}

}


class Point {
	int y, x;

	Point(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
