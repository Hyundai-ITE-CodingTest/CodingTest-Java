import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        //연결 관계 생성
        boolean[][] visited = new boolean[n+1][n+1];
        for(int i = 0; i < edge.length; i++){
            int start = edge[i][0];
            int end = edge[i][1];
            visited[start][end] = true;
            visited[end][start] = true;
        }
        //노드 기준 연결 간선
        int[] arr = new int[n+1];
        //bfs 큐 생성
        Queue<Integer> q = new LinkedList<>();   
        
        q.add(1); //첫번째 노드 삽입
        arr[1] = 1;
        while(!q.isEmpty()){
            //현재 노드
            int cur = q.poll();
            for(int i = 2; i <= n; i++){
                if(arr[i] == 0 && visited[cur][i]){
                    arr[i] = arr[cur] + 1;
                    q.add(i);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        int answer = 0;
        for(int i = 0; i <=n; i++){
            if(arr[i] == max){
                answer++;
            }
        }
        return answer;
    }
}
