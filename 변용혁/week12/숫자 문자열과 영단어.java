import java.util.*;

class Solution {
    public int solution(String s) {
        String answer = "";
        String num = "";
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        
        
        for(int i=0; i<s.length(); i++){
            char a = s.charAt(i);
            if('0' <= a && a <= '9'){
                answer += a;
            }else{
                num += a;
                if(map.	containsKey(num)){
                    answer += map.get(num);
                    num = "";
                }
            }
            
        }
        
        return Integer.parseInt(answer);
    }
}
