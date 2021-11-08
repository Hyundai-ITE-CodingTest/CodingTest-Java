class Solution {
    public int solution(int[][] triangle) {
       int depth = triangle.length;
       
        for(int i= depth-2; i >=0 ; i--){
            int leng = triangle[i].length;
            //System.out.println("leng " + leng);
            for(int j=0; j < leng; j++){
                int max = -1;
                //왼쪽 대각선
                max = Math.max(max, triangle[i+1][j]);
                //오른쪽 대각선
                max = Math.max(max, triangle[i+1][j+1]);
                
                triangle[i][j] += max;
            }
        }
        
        //System.out.println(triangle[0][0]);
        
        return triangle[0][0];
    }
}
