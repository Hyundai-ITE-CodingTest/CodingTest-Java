class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // 노란사각형의 가로가 x, 세로가 y
        // 외부갈색 사각형의 공식 = 2x + 2y + 4
        int x = yellow;
        for(int y=1; y <= yellow; y++) {
            if((2*x + 2*y + 4) == brown) {
                answer[0] = x+2; answer[1] = y+2; // 양 옆으로 +1
                break;
            }
            
            // 0으로 나누어떨어질 때만
            if(yellow % (y+1) == 0)
                x = yellow / (y+1);
        }
        
        return answer;
    }
}