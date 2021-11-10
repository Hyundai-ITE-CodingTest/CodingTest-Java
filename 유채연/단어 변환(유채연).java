import java.util.*;


class Solution {
    int wordsN=0;
    int eachWordN=0;
    int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        
        wordsN = words.length;
        eachWordN = words[0].length();
        boolean[] check = new boolean[wordsN];
        
        dfs(words, begin, target, check, 0);
        
        return answer;
    }
    
    public void dfs(String[] words, String begin, String target, boolean[] check, int cnt){
        wordsN = words.length;
        eachWordN = words[0].length();
        
        if(begin.equals(target)){
            if(cnt > wordsN) {answer= wordsN;}
            else{answer= cnt;}
        }
        for(int i=0; i<wordsN; i++){
            int sameN = 0;
            
            for(int j=0; j<eachWordN; j++){
                sameN += (begin.charAt(j)==words[i].charAt(j)?1:0);
            }
            
            if(sameN == eachWordN-1 && !check[i]){
                check[i]=true;
                dfs(words, words[i], target, check, cnt+1);
                check[i]=false;
            }
        }
    }
}