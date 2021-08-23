class Solution {
    public int solution(String s) {
        int n = s.length();
        int answer = n;
        int press = 1;
        int max_compress = n / 2; 
        
        
        while(press <= max_compress) {
            String result = "";
            String prev = "";
            int count = 1;
            String now = "";
            int idx = 0;
            while(idx <= (n-press)) { // 압축크기만큼 idx증가
                now = s.substring(idx, idx+press);
                if(prev.equals(now)) {
                    count++;
                }
                else {
                    if(count > 1) 
                        result += String.valueOf(count);
                    result += prev;
                    count = 1;
                    prev = now;
                }
                idx+=press;
            }
            
            // 뒤에 비교하는 게 다를때만 result에 추가했기 때문에
            // 뒷부분 끝까지 남아있는 것 더해줌
            if(count > 1)
                result += String.valueOf(count);
            result += now;
            result += s.substring(idx, n);
            
            press++;
            answer = Math.min(answer, result.length());
        }
        
        return answer;
    }
}