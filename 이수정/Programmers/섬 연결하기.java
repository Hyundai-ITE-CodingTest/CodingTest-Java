import java.util.*;
class Solution {
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2]; //작은 순서대로 정렬 필요
            }
        });
        boolean[] checked = new boolean[costs.length]; //비용 배열을 모두 확인하자.
        boolean[] visited = new boolean[n]; //모든 노드들이 연결됬느지 여부
        checked[0] = true;
        int start = costs[0][0]; int end = costs[0][1];
        visited[start] = true; visited[end] = true;
        int weight = costs[0][2];
        answer += weight;
        int cnt = 2;
        while(cnt < n){
            for(int i = 1; i < costs.length; i++){
                start = costs[i][0];
                end = costs[i][1];
                weight = costs[i][2];
                if(checked[i]== false &&
                   (visited[start]==true&&visited[end]==false) ||
                   (visited[start]==false&&visited[end]==true)) {
                    checked[i] = true;
                    visited[start] = true;
                    visited[end] = true;
                    cnt++;
                    answer += weight;
                    break;
                }
            }
        }
        return answer;
    }
}
