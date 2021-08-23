import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        // uid로 유저를 식별해야한다.
        // uid를 키로 두고 value값으로 닉네임을 저장한다.
        HashMap<String, String> users = new HashMap<>();
        
        
        for (String rec : record){ // 명령어 처리
            // split sp[0]명령어 sp[1]uid sp[2]nickName
            String[] sp = rec.split(" ");
            // 명령어 Enter, Change
            switch (sp[0]){
                case "Enter":
                case "Change":
                    // Enter : users에 없으면 넣어주고 key=uid, value=nickName
                    users.put(sp[1], sp[2]);
                    break;
            }
        }
        ArrayList<String> list = new ArrayList();
        // 결과는 따로 처리
        for (String rec : record){
            String[] sp = rec.split(" ");
            switch (sp[0]){
                case "Enter":
                    list.add(users.get(sp[1]) + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    list.add(users.get(sp[1]) + "님이 나갔습니다.");
                    break;
            }
        }
        String[] answer = new String[list.size()];
        answer = list.toArray(answer);
        
        return answer;
    }
}