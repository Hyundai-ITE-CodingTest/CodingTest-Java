import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean[][] arr = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				if(str.charAt(j) == 'B') {
					arr[i][j] = true;
				}else {
					arr[i][j] = false;
				}
			}
		}
		int answer = 2500;
		
		for(int i = 0; i < n-7; i++) {
			for(int j = 0; j < m- 7; j++){
				answer = Math.min(answer,check(i,j,arr));
			}
		}
		System.out.println(answer);

	}

	static int check(int start, int jstart, boolean[][] arr) {
		int cnt1, cnt2;
		cnt1 = cnt2 = 0;
		
		for (int i = start; i < start + 8; i++) {
			for (int j = jstart; j < jstart + 8; j++) {
				if((i+j)%2 == 0) { // 두 가지 경우로 나눠서 생각 (B로 시작 W로 시작)
					if(arr[i][j]) {
						cnt1++;
					}else {
						cnt2++;
					}
				}else {
					if(arr[i][j]){
						cnt2++;
					}else {
						cnt1++;
					}
				}
	
			}
		}
		return Math.min(cnt1,cnt2);

	}

}
