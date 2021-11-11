import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> list = new ArrayList<>();
        Map<String,String> map = new HashMap<>(); //key=id, value=nickname
        
        for(String records : record){
            String[] input = records.split(" "); //들어온 입력 문자열 공백으로 나누기
            if(input[0].equals("Enter")){
                map.put(input[1], input[2]);
                list.add(records);
            }else if(input[0].equals("Leave")){
                list.add(records);
            }else if(input[0].equals("Change")){
                map.put(input[1], input[2]);
            }
        }
        String[] answer = new String[list.size()];
        for(int i = 0; i<answer.length; i++){
            String[] s = list.get(i).split(" ");
            if(s[0].equals("Enter")){
                answer[i] = map.get(s[1])+"님이 들어왔습니다.";
            }else if(s[0].equals("Leave")){
                answer[i] = map.get(s[1])+ "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}
