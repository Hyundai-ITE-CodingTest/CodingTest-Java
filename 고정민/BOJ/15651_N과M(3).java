import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken()); //배열의 길이 
		int[] ans = new int[m];
		permutation(n, m, ans, 0);
		System.out.println(sb.toString());
	}
	
	public static void permutation(int n, int m, int[] ans, int depth) throws IOException {
		if(m==depth) {
			for(int a : ans) {
				sb.append(a).append(' ');
			}
			sb.append('\n');
			return;
		}else {
			for(int i=1;i<=n;i++) {
				ans[depth] = i;
				permutation(n, m, ans, depth+1);
			}
		}
	}
}
