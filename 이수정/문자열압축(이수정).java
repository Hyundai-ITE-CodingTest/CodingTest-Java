class Solution {
    public int solution(String s) {
        int answer = 0;
        //총 길이 문자 길이 2로 나눈 값 : 구분 종류 개수
        //1문자: 0(1*0) 1(1*1), 1(1*1) 2(1*2), 2 3, 3 4, 4 5, 5 6, 6 7, 7 8, 8 9
        //2문자: 0(2*0) 2(2*1), 2(2*1) 4(2*2), 4 6, 6 8
        //3문자: 0(3*0) 3(3*1), 3(3*1) 6(3*2), 6 9
        //4문자: 0(4*0) 4(4*1), 4(4*1) 8(4*2)
        answer = 1000; // 제한사항 참고
//       //문자열 길이가 1개일 경우
        if(s.length() == 1)
            answer = 1;
        // 문자열 기준 1~length 까지
        for(int i=1; i<= s.length()/2; i++){// 1,2,3,4
            String curr = ""; String next = ""; String pattern = "";
            int count = 1; // 패턴 동일 개수 증가

            // j 기준 단위 0부터 length/i 단위까지
            for(int j= 0; j<=s.length()/i;j++){ //i = 1, j: 0 ~ 9 i = 2, j: 0~ 4
                int from = i *j ; int to = i*(j+1);
                if(to > s.length()) to = s.length();
                
                curr = next;
                next = s.substring(from, to);

                // 비교
                if(curr.equals(next)) count++;
                else{
                    if(count>1) pattern += String.valueOf(count);
                    pattern += curr;
                    count = 1; // 개수 초기화
                }
            }
            if(count>1) pattern += String.valueOf(count);
            pattern += next;
            answer = Math.min(pattern.length(), answer);
        }
        return answer;
    }
}
