import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[][] W;
	static int N;
	static boolean[] visited;
	static int defaultStart;
	static int MIN = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 
		4
		0 10 15 20
		5 0 9 10
		6 13 0 12
		8 8 9 0
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		visited = new boolean[N];
		
		for(int i=0; i < N; i++) {
			W[i] = Arrays.asList((br.readLine()).split(" ")).stream().mapToInt(Integer::parseInt).toArray();		
		}
		
		for(int i=0; i < N; i++) {
			defaultStart = i;
			visited[i] = true;
			Traversal(i, 1, 0);
			visited[i] = false;
		}
		System.out.println(MIN);
	}
	
	static void Traversal(int start, int traveledNum, int cost) {
		if(traveledNum == N && W[start][defaultStart] != 0 ) {
			cost += W[start][defaultStart];
			if(cost < MIN) {
				MIN = cost;
			}
			return;
		}
		
		//인접 국가 방문
		for(int i=0; i <N; i++) {
			if(visited[i]) {
				continue;
			}
			if(W[start][i] == 0) {
				continue;
			}
			visited[i] = true;
			Traversal(i, traveledNum + 1, cost + W[start][i]);
			visited[i] = false;
		}
		return;
	}

}
