import java.util.*;

public class Solution {
	public static String[] solution(String[] record) {
		
		int len = record.length;
        String[] answer = new String[len];
        Map<String, String> map = new HashMap<String, String>();
        int cnt = 0; //결과 갯수 카운트
        String[][] temp = new String[len][2]; // id + 메세지 저장
        
        for(int i=0; i<len; i++) {
        	String[] msg = record[i].split(" ");
        	if (msg[0].equals("Enter")) {
        		
        		map.put(msg[1], msg[2]);
        		temp[cnt][0] = msg[1];
        		temp[cnt][1] = "님이 들어왔습니다.";
        		cnt += 1;
        		
        	}else if(msg[0].equals("Change")) {     
        		
        		map.put(msg[1], msg[2]);
        		
        	}else if(msg[0].equals("Leave")) {
        		
        		temp[cnt][0] = msg[1];
        		temp[cnt][1] = "님이 나갔습니다.";
        		cnt += 1;
        		
        	}
        }
        
        for(int i=0; i<cnt; i++) {
        	answer[i] = map.get(temp[i][0]) + temp[i][1];
        }
        
        return Arrays.copyOf(answer, cnt);
    }
	
}
