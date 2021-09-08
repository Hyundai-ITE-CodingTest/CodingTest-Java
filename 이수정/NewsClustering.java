import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        String pattern = "^[a-zA-Z]*$";
        double union_count; double inter_count;
        
        List<String> list_str1 = new ArrayList<String>();
        List<String> list_str2 = new ArrayList<String>();
        
        str1= str1.toLowerCase();
        str2= str2.toLowerCase();
        for(int i = 0; i < str1.length()-1; i++){
            String temp = "";
            temp = str1.substring(i,i+2);
            //문자열에 유효한 글자는 only 영문자, 아예 버림
            if(Pattern.matches(pattern,temp)==true){
                list_str1.add(temp);
            }
        }
        for(int i = 0; i < str2.length()-1; i++){
            String temp = "";
            temp = str2.substring(i,i+2);
            //문자열에 유효한 글자는 only 영문자, 아예 버림
            if(Pattern.matches(pattern,temp)==true){
                list_str2.add(temp);
            }
        }
        List<String> intersection = new ArrayList<String>();
        List<String> union = new ArrayList<String>();
        // 교집합 구하기
        for(String s : list_str1) {
            if(list_str2.remove(s)) {
                intersection.add(s);
            }
            union.add(s);
        }
        // 합집합 구하기
        for(String s : list_str2) {
            union.add(s);
        }
        inter_count = intersection.size();
        union_count = union.size();
        
        if(inter_count == 0 || union_count ==0){
             return answer = 65536;
        }else{
            return answer = (int)Math.floor((inter_count/union_count) * 65536);
        }
    }
}
