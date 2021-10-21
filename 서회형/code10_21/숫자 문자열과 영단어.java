class Solution {
    public int solution(String s) {
        int answer = 0;
        int j = 0;
        String [] num = {"zero", "one", "two", "three", "four", "five", "six","seven","eight","nine"};
        
        for(String i : num){
            s = s.replace(i,  Integer.toString(j));
                               j++;
        }
        
        answer = Integer.parseInt(s);
        
        return answer;
    }
}