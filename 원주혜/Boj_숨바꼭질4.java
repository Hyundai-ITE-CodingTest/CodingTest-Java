import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

	static int N, K;
	static Integer[] line = new Integer[200001];
	static Integer[] parents = new Integer[200001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.asList((br.readLine()).split(" ")).stream().mapToInt(Integer::parseInt).toArray();
		N = input[0];
		K = input[1];
		
		line[N] = 0;
		parents[N] = N;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(N);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();

			//+1
			if(cur + 1 > 200000) {
				continue;
			}
			if(line[cur+1] == null) {
				queue.add(cur+1);	
				line[cur+1] = line[cur] + 1;
				parents[cur+1] = cur;
			}
			
			//-1
			if(cur -1 < 0) {
				continue;
			}
			if(line[cur-1] == null) {
				queue.add(cur-1);
				line[cur-1] = line[cur] + 1;
				parents[cur-1] = cur;
			}
			
			// * 2
			if((cur * 2) < 0 || (cur * 2) > 200000) {
				continue;
			}
			if(line[cur*2] == null) {
				queue.add(cur*2);
				line[cur*2] = line[cur] + 1;
				parents[cur*2] = cur;
			}
		}
		System.out.println(line[K]);
		shortestPath();
	}
	
	static void shortestPath() {
		Stack<Integer> path = new Stack<>();
		path.push(K);
		int start = K;
		
		while(parents[start] != N) {
			path.push(parents[start]);
			start = parents[start];
		}
		if(N != K) {
			path.push(N);
		}
		
		StringBuilder sb = new StringBuilder();
		while(path.size() > 1) {
			sb.append(path.pop() + " ");
		}
		sb.append(path.pop());
		System.out.print(sb);
	}

}
