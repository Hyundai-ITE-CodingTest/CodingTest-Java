import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        int[] visited = new int[n+1];
        visited[1] = 1;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        
        while(!q.isEmpty()){
            int current = q.poll();
            
            for(int i =0; i<edge.length; i++){
                if(current == edge[i][0] && visited[edge[i][1]]==0){
                    visited[edge[i][1]] = visited[current]+1;
                    q.add(edge[i][1]);
                }else if(current == edge[i][1] && visited[edge[i][0]]==0){
                    visited[edge[i][0]] = visited[current]+1;
                    q.add(edge[i][0]);
                }
            }
        }
        
        Arrays.sort(visited);
        int max = visited[visited.length-1];
        for(int v : visited){
            if(v==max)  answer++;
        }
        
        return answer;
    }
}
