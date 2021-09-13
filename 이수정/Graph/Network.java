class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for(int i =0; i< n; i++){
            if(visited[i] == false){
                answer++;
                dfs(computers, i, visited);
            }
        }
        return answer;
    }
    public void dfs(int[][] com, int node, boolean[] visited){
         visited[node] = true;
         for(int i = 0; i<com.length; i++){
             if(node != i){
                 if(com[node][i] == 1 && visited[i] == false){
                     dfs(com, i, visited);
                 }
             }
         }
     }
}
