class Solution {
    static boolean[] visited;
	static int[][] Scomputers;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        Scomputers = computers;
        visited = new boolean[n];
        
		for(int i=0; i < n; i++) {
        	if(!visited[i]) {
        		//System.out.println("visit!");
        		answer += dfs(i);
        	}
        }
		
		//System.out.println("answer "+answer);
        return answer;
    }
    
    public int dfs(int root) {
		
		visited[root] = true;
		
		for(int i=0; i < Scomputers[root].length; i++) {
			if(Scomputers[root][i] == 0) continue;
			if(visited[i]) continue;
			
			visited[i] = true;
			dfs(i);
		}
		return 1;
	}
}
