import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int n, m;
	public static boolean[] visited;
	public static int[] out;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] line = bf.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		visited = new boolean[n]; // initial false
		out = new int[m];

		btk(0, n, m);
		System.out.println(sb);
	}

	public static void btk(int depth, int n, int m) {
		if (depth == m) {
			for (int val : out) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				out[depth] = i + 1;
				btk(depth + 1, n, m);
				visited[i] = false;
			}
		}
	}
       
}