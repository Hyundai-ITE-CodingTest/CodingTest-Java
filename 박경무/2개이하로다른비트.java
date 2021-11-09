
class Solution {
    public long[] solution(long[] numbers) {
         long[] answer = new long[numbers.length];
        for(int i=0; i<numbers.length; i++){
            // System.out.println(Long.toBinaryString(numbers[i]));
            String numbers_str = Long.toBinaryString(numbers[i]);
            long next = numbers[i]+1;
            
            loop1:
            while(true){
                int cnt=0;
                String next_str = Long.toBinaryString(next);
                //다음 숫자의 횟수만큼 반복
                for(int j=0; j<next_str.length(); j++){
                    int num_now_char =numbers_str.length()-1-j;
                    int next_now_char =next_str.length()-1-j;
                    if(num_now_char>=0){
                        if(numbers_str.charAt(num_now_char) != next_str.charAt( next_now_char)){
                            cnt++;
                         }
                    }else{
                        if(next_str.charAt( next_now_char)=='1'){
                            cnt++;
                        }
                    }
                    if(cnt>=3){
                       continue;
                    }
                }
                if(cnt<=2){
                    answer[i]=next;
                    break;
                }else{
                    next++;
                }
            }
            
            
        }
        
       
        return answer;
    }
}
