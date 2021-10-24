import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.*;
class Solution {
    public String solution(String number, int k) {
    int pos = 0;
    char max;
    StringBuilder answer = new StringBuilder();  
    
        if(number.charAt(0) =='0'){
            return "0";
        }
        for(int i = 0; i < number.length() - k; i++){
            max = '0';
            
            for(int j = pos; j <= k + i;j++ ){
                if(max < number.charAt(j)){
                    max = number.charAt(j);
                    pos = j + 1;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }
}