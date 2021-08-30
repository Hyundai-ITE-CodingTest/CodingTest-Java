class Solution {
  public int[] solution(int brown, int yellow) {
      int width = 0;
      int height = 0;
      
      for(int i=yellow;i>0;i--){
          if(yellow%i==0){
          int j = yellow/i;
          if(brown==((i+2)*(j+2))-yellow){
            width = i+2;
            height = j+2;
            break;
          }
          }else continue;
  }
      int[] answer = {width, height};
      return answer;
  }
}
