import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int maxdist = 0;
        
        boolean[] visit = new boolean[n];
        int[] node = new int[n];
        boolean[][] edgeMatrix = new boolean[n][n];
        Queue<Integer> que = new LinkedList<Integer>();
        
        for(int[] e: edge){
            edgeMatrix[e[0]-1][e[1]-1] = true;
            edgeMatrix[e[1]-1][e[0]-1] = true;            
        }
        
        que.add(0);
        visit[0] = true;
        
        while(que.size() > 0){
            int temp = que.poll();
            
            for(int i=0; i<n; i++){
                if(edgeMatrix[temp][i] && !visit[i]){
                    que.add(i);
                    visit[i] = true;
                    node[i] = node[temp] + 1;
                    if(maxdist < node[i]){
                        maxdist = node[i];
                    }
                }
            }
        }
        
        for(int i=0; i<n; i++){
            if(maxdist == node[i]){
                answer++;
            }
        }
        
        return answer;
    }
}
