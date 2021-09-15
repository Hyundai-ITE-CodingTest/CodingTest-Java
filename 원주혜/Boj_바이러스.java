
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Boj_virus {

	static HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>(); 
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int comNum = Integer.parseInt(br.readLine());
		int pairNum = Integer.parseInt(br.readLine());
		
		visited = new boolean[comNum+1];
		for(int i=0; i < comNum; i++) {
			graph.put(i+1, new ArrayList<Integer>());
		}
		
		//make graph
		for(int i=0; i < pairNum; i++) {
			String[] arr = (br.readLine()).split(" ");
			int key = Integer.parseInt(arr[0]);
			int connected = Integer.parseInt(arr[1]);
			
			ArrayList<Integer> connections = graph.get(key);
			ArrayList<Integer> connections2 = graph.get(connected);
			connections.add(connected);
			connections2.add(key);
			
			graph.put(key, connections);
		}
		//dfs - 1번 컴퓨터 시작
		int answer = dfs(1) - 1;
		System.out.println(answer);
	}
	
	public static int dfs(int root) {
		int answer = 1;
		
		visited[root] = true;
		ArrayList<Integer> connections = graph.get(root);
		for(int i=0; i < connections.size(); i++) {
			int com = connections.get(i);
			if(visited[com]) continue;
			answer += dfs(com);
		}
		
		return answer;
	}

}
