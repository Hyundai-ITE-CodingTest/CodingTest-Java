import java.util.Arrays;
import java.util.Comparator;

class Solution {
  int[] array;

  public int find(int x){
      if(array[x] == x)   return x;
      return array[x] = find(array[x]);
  }

  public int solution(int n, int[][] costs) {
      array = new int[n];
      int sum = 0;

      for(int i=0; i<n; i++){
          array[i] = i;
      }

      Arrays.sort(costs, new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
          return o1[2] - o2[2];
        }
      });

      for(int i =0; i<costs.length; i++) {
        int node1 = find(costs[i][0]);
        int node2 = find(costs[i][1]);

              if(node1 != node2){
                  array[node1] = node2;
                  sum += costs[i][2];
              }
          }
          return sum;
      }
}
