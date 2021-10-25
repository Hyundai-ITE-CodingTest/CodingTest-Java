import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n; //크기
	static int[][] map; //2차원 지도
	static int[] dx = {-1, 1, 0, 0}; //상하좌우
	static int[] dy = {0, 0, -1, 1}; //상하좌우
	static List<Integer> ans; // 단지 수를 담을 list
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		ans = new ArrayList<>();
		
		//지도 입력
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j=0; j<n; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		//지도 탐색
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]==1) {
					cnt=0;
					dfs(i, j);
					ans.add(cnt);
				}
			}
		}
		sb.append(ans.size()+"\n");
		Collections.sort(ans);
		for(int a : ans) {
			sb.append(a+"\n");
		}
		System.out.println(sb.toString());
	}
	
	public static int dfs(int x, int y) {
		map[x][y] = 0;
		cnt++;

		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && nx<n && ny>=0 && ny<n) {
				if(map[nx][ny]==1) {
					dfs(nx, ny);
				}
			}
		}
		return cnt;
	}
}
