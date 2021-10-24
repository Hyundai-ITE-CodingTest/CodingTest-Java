class Solution {
    public String solution(int n) {
        String answer = "";
        String[] number = {"4","1","2"};
        while(n > 0){
        //n % 3 은 순차적으로 1, 2, 0 순서를 가짐
        answer = number[n %3] + answer; //앞에 숫자가 append
        n = (n - 1) /3;
        }
        return answer;
    }
}
