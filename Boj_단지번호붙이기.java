import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int num;
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		7
		0110100
		0110101
		1110101
		0000111
		0100000
		0111110
		0111000
		*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			String[] line = br.readLine().split("");
			for(int j=0; j < N; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		ArrayList<Integer> numlist = new ArrayList<Integer>();
		
		for(int i = 0; i < N; i++) {
			for(int j=0; j < N; j++) {
				num = 0;
				if(!visited[i][j]) {
					if(dfs(i, j)) {
						numlist.add(num);
					}
				}
			}
		}
		numlist.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
		
		System.out.println(numlist.size());
		System.out.println(numlist.stream().map(Object::toString).collect(Collectors.joining("\n")));

	}
	
	public static boolean dfs(int r, int c) {
		
		if(map[r][c] == 0) {
			return false;
		}
		
		visited[r][c] = true;
		++num;
		
		/*
		 * 좌우아래위 이웃탐색
		 * */
		
		if(r > 0) {
			if(!visited[r-1][c]) {
				dfs(r-1, c);
			}
		}
		if(r < N-1) {
			if(!visited[r+1][c]) {
				dfs(r+1, c);
			}
		}
		if(c > 0) {
			if(!visited[r][c-1]) {
				dfs(r, c-1);
			}
		}
		if(c < N-1) {
			if(!visited[r][c+1]) {
				dfs(r, c+1);
			}
		}
		return true;
	}
}
