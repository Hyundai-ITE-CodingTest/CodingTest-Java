import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length;i++){
            ArrayList<Integer> sorted = new ArrayList<>();
            for(int j = commands[i][0]; j <= commands[i][1]; j++){
                int arrs = array[j-1];
                sorted.add(arrs);
            }
            Collections.sort(sorted);
            int k = sorted.get(commands[i][2]-1);
            answer[i] = k;
        }
        return answer;
    }
}
