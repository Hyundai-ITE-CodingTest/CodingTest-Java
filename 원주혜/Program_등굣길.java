import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    
  ArrayList<Integer> routes = new ArrayList<Integer>();
	int[][] roads;
	int n, m;
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    public int solution(int m, int n, int[][] puddles) {
        this.m = m;
        this.n = n;
        roads = new int[n + 1][m + 1];
        
		for (int[] puddle : puddles) {
			roads[puddle[1]][puddle[0]] = -1;
		}
        
        roads[n][m] = 1;
        calRoutes(n, m);
        
		// for (int i = 0; i < n + 1; i++) {
		// 	for (int j = 0; j < m + 1; j++) {
		// 		System.out.print(roads[i][j] + "	");
		// 	}
		// 	System.out.println();
		// }
        
		System.out.println(roads[1][1] % 1000000007);
        return roads[1][1]  % 1000000007;
    }
    
    void calRoutes(int r, int c) {
		for(int i= r; i > 0; i-- ) {
			for(int j=c; j > 0; j--) {
				
				if(roads[i][j] < 0) {
					continue;
				}
				
				if(i+1 < n+1) {
					roads[i][j] += roads[i+1][j] < 0 ? 0: roads[i+1][j]  % 1000000007;
                    
				}
                
				if(j+1 < m+1) {
					roads[i][j] += roads[i][j+1] < 0 ? 0 : roads[i][j+1]  % 1000000007;
				}
			}
		}
	}
}
