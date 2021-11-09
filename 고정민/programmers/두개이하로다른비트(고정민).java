/*
풀이 참고했음
1. numbers의 원소가 짝수면 그 다음 값이 제일 작은 수
2. numbers의 원소가 홀수면 이진수에서 가장 마지막에 있는 0을 1로 바꾸고, 그 다음 오는 1을 0으로 바꾼다.
*/
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0; i<numbers.length; i++){
            if(numbers[i]%2==0) answer[i] = numbers[i]+1;
            else{
                String binary = "0"+Long.toBinaryString(numbers[i]);
                StringBuilder sb = new StringBuilder(binary); //문자열 변환을 위해

                int zeroidx = sb.lastIndexOf("0"); //가장 마지막에 있는 0을 찾음
                sb.setCharAt(zeroidx,'1'); //1로 치환
                int oneidx = sb.indexOf("1", zeroidx+1); //가장 마지막에 있는 0의 인덱스 다음값부터 1을 갖고있는 인덱스
                sb.setCharAt(oneidx, '0'); //0으로 치환

                String result = sb.toString();
                answer[i] = Long.parseLong(result, 2);

            }
        }
        return answer;
    }
}
