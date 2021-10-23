class Solution {
    public String solution(int n) {
        		String answer = "";
        int i = 9;
        int j = 0;
        
        while(n != 0){
            if (n % 3 == 0 ){
               answer = "4" + answer; 
                n = n/3 -1;  
            }
            else if (n % 3 == 1  ){
               answer = "1" +  answer ;
                n = n/3;
            }
            else if (n % 3 == 2  ){
               answer = "2" + answer;
                n = n/3;
            }
      
            i--;
        }
      
        
        return answer;
    }
}