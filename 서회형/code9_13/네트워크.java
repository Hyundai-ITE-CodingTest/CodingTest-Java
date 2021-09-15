class Solution {
    public int solution(int n, int[][] com) {
        int answer = 0;
        boolean[] visited = new boolean[com.length];
        
        for(int i = 0; i < com.length; i++){
            visited[i] = false;
        }
        
        for(int i = 0; i < com.length; i++){
            if(visited[i] == false){
                answer++;
                dfs(i, visited,com);
            }
        }
        return answer;
    }
    
    public void dfs(int node, boolean visited[], int[][] com){
        visited[node] = true;
        
        for(int i = 0; i < com.length; i++){
        if(visited[i] == false && com[node][i] == 1)
             dfs(i, visited,com);
        }
    }
        
} 