import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        int answer = 0;
        int no = 1;
        int index = 0;
        
        Arrays.sort(citations);
        
        if(citations[0] > citations.length){
            return citations.length;
        }
        
        while(no <= citations.length){
            index = citations.length - no;
            
            if(citations[index] < no){
                return no-1;
            }
            no++;
        }
        return answer;
    }
}
