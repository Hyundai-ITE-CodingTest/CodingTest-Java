class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int remains = number.length() - k; //6
        int start = -1;
        int end = k;
        StringBuilder sb = new StringBuilder();

        while(remains > 0){
            int max = 0;
            for(int i = start+1; i <= end; i++){
                int n = number.charAt(i) -'0';
                if(max < n) {
                    max = n;
                    start = i;//2
                    //System.out.println(max);
                }
            }
            end++;
            remains--;
            sb.append(max);
        }
        answer = sb.toString();
        return answer;
    }
}
