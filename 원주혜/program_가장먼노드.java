import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    Node[] graph;
	boolean[] visited;
    
    public int solution(int n, int[][] edge) {
        visited = new boolean[n+1];
		graph = new Node[n+1];
		
		//그래프 만들기
		for (int i = 0; i < edge.length; i++) {
			if(graph[edge[i][0]] == null) {
				graph[edge[i][0]] =  new Node(edge[i][0]);
			}
			if(graph[edge[i][1]] == null) {
				graph[edge[i][1]] = new Node(edge[i][1]);
			}
			graph[edge[i][0]].addFriends(edge[i][1]);
			graph[edge[i][1]].addFriends(edge[i][0]);
		}
		int answer = bfs(1);
        //System.out.println(answer);
        return answer;
    }
    
    int bfs(int root) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> parents = new LinkedList<Integer>();
		queue.add(root);
		visited[root] = true;
		
		int answer = 0;
		
		while(!queue.isEmpty()) {
			//int cur = queue.poll();
			
			while(!queue.isEmpty()) {
				parents.add(queue.poll());
			}
			
			answer = parents.size();
			
			while(!parents.isEmpty()) {
				int parent = parents.poll();
				
				for (Integer friend : graph[parent].friends) {
					if(!visited[friend]) {
						visited[friend] = true;
						queue.add(friend);
					}
				}
			}
		}
		
		return answer;
	}
}

class Node{
	int num;
	ArrayList<Integer> friends = new ArrayList<Integer>();
	
	Node(int num){
		this.num = num;
	}
	
	void addFriends(int friend){
		friends.add(friend);
	}
	
}
