import java.util.*;

class Info {
    String nickname;
    ArrayList<Integer> idx = new ArrayList<>();
    ArrayList<String> command = new ArrayList<>();
    
    Info(String nickname, Integer idx, String command) {
        this.nickname = nickname;
        this.idx.add(idx);
        this.command.add(command);
    }
    
}

class Solution {
    public String[] solution(String[] record) {
        
        // uid -> Info(nickname, idx, command) 로 들어감.
        HashMap<String, Info> uids = new HashMap<>();
        
        int idx = 0;
        for(String commands : record) {
            String[] command = commands.split(" ");
            if(command[0].equals("Enter")) {
                if(!uids.containsKey(command[1])) { // 처음 입력된 uid인 경우
                    uids.put(command[1], new Info(command[2], idx, command[0]));
                } else { // 이미 존재하는 uid인 경우
                    uids.get(command[1]).nickname = command[2];
                    uids.get(command[1]).idx.add(idx);
                    uids.get(command[1]).command.add(command[0]);
                }
                idx++;
            }
            else if(command[0].equals("Leave")) {
                uids.get(command[1]).idx.add(idx);
                uids.get(command[1]).command.add(command[0]);
                idx++;
            }
            else if(command[0].equals("Change")) {
                uids.get(command[1]).nickname = command[2];
            }
        }
        
        String[] answer = new String[idx];
        
        for(String uid : uids.keySet()) {
            Info userInfo = uids.get(uid);
            String username = userInfo.nickname;
            for(int i=0; i < userInfo.command.size(); i++) {
                int index = userInfo.idx.get(i);
                String comm = userInfo.command.get(i);
                if(comm.equals("Enter"))
                    answer[index] = username + "님이 들어왔습니다.";
                else if(comm.equals("Leave"))
                    answer[index] = username + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}