import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i = 1; i <= s.length(); i++){ 
            String comp = "";
            String temp = s.substring(0, i);
            int count = 0;
            
            for (int j = 0; j < s.length(); j+=i){
                if(j+i <= s.length()){
                    if(temp.equals(s.substring(j, j+i))){
                        count++;
                    } else {
                        if(count > 1){
                            comp += count;
                        }
                        comp += temp;
                        count = 1;
                        temp = s.substring(j, j+i);
                    }
                } else{
                    if (count > 1){
                        comp += count;
                    }
                    comp += temp + s.substring(j, s.length());
                }
                
                if(j+i == s.length()){
                    if(count > 1){
                        comp += ((count) + temp);
                    } else{
                        comp += temp;
                    }
                }
            }
            if (answer == 0){
                answer = comp.length();
            } else{
                answer = Math.min(answer, comp.length());
            }
            
        }
        return answer;
    }
}
