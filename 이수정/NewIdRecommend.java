class Solution {
    public String solution(String new_id) {
        String answer = "";
        answer = new_id;
        //1단계: 대문자는 소문자로 치환
        answer = answer.toLowerCase();
        //System.out.println("1단계:"+ answer);
        //2단계: 특수문자 정리, 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
        answer = answer.replaceAll("[^-_.a-z0-9]","");
        //System.out.println("2단계:"+ answer);
        //3~4단계: . 조건 충족 3) 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
        while(answer.contains("..")){
            answer = answer.replace("..",".");
        }
        //마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if(answer.length() > 1){
            if(answer.charAt(0) == '.') //첫번째 0일 경우
                answer = answer.substring(1,answer.length());
            if(answer.charAt(answer.length()-1) =='.')
                answer = answer.substring(0,answer.length()-1);
        }else if(answer.length() == 1 && answer.equals(".")){
            answer = answer.replace(".","");
        }
        //System.out.println("3,4단계:"+ answer);
        //5단계: 빈 문자열 => a
        if(answer.length()==0) answer = "a";
        //System.out.println("5단계:"+ answer);
        //6단계: 길이가 16자 이상이면, 15개만 빼고 제거
        //만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if(answer.length() > 15) {
            answer = answer.substring(0,15);
            if(answer.charAt(answer.length()-1) == '.')
                answer = answer.substring(0,answer.length()-1);
        }
        //System.out.println("6단계:"+ answer);
        //7단계: 2자 이상 마지막 문자 반복
        if(answer.length() < 3){
            while(answer.length() < 3){
                answer += answer.charAt(answer.length()-1);
            }
        }
        return answer;
    }
}
