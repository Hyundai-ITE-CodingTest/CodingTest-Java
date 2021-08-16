import java.util.ArrayList;
import java.util.HashMap;
class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        ArrayList<String> list = new ArrayList(); // 출력 값을 저장한다.
        HashMap<String, String> hm = new HashMap(); //유저 아이디에 따라 변경되는 닉네임을 저장한다

        for (int i = 0; i < record.length; i++) {
            String[] words = record[i].split(" "); // 띄어쓰기로 글자를 자른다
            if (words[0].equals("Enter")) { //enter 일 경우
                list.add(words[1] + "님이 들어왔습니다.");
                hm.put(words[1], words[2]);
            } else if (words[0].equals("Change")) {// 닉네임 변경
                hm.put(words[1], words[2]);
            } else {//leave 경우
                list.add(words[1] + "님이 나갔습니다.");
            }
        }
        // for(int i = 0; i< list.size(); i++){
        //     System.out.println(arr.get(i));
        // }
        answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            int idx = list.get(i).indexOf("님");
            String id = list.get(i).substring(0, idx); //사용자 아이디
            String[] words = list.get(i).split(" ");
            answer[i] = hm.get(id) + "님이 " + words[1]; //들어왔습니다. | 나갔습니다.
        }
        // for(int i = 0; i< list.size(); i++){
        //     System.out.println(answer[i]);
        // }
        return answer;
    }
}
//풀이법
/*
1. 사용자 아이디에 따른 닉네임을 저장한다 -> hash 활용
2. enter은 사용자 추가 change 일경우 key에 따른 값을 변경한다
3. key에 해당하는 값을 가져와 결과를 출력한다
*/
