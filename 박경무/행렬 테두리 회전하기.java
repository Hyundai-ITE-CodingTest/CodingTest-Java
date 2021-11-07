//구성이 복잡하여 직접 회전, 최소 수 찾기를 구현해야한다.

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        
        int[][] board = new int[columns][rows];
        int cnt=1;
        int[] answer = new int[queries.length];
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                board[j][i]=cnt;
                cnt++;
            }
        }
        //회전 구현
        //좌상단 꼭짓점 입력받기
        //우하단 꼭짓점 입력받기
        //가로 길이 구하기
        //세로길이 구하기
        //반복하면서 가장 작은 값 찾기 Math.min 활용
        //좌상단 꼭지에서 가로 길이-1 만큼 단순 오른쪽 옮기기
        //우상단 꼭지에서 세로길이 -1 만큼 단순 아래로 옮기기
        //우하단 꼭지에서 좌하단 꼭지로 가로길이-1만큼 옮기기
        //좌하단에서 좌상단으로 세로 길이-1 만큼 옮기기
        // p1 p2 p3 p4 좌상단 우상단 우하단 좌하단
        for(int i=0; i<queries.length; i++){
            int min = Integer.MAX_VALUE;
            int x1=queries[i][1]-1;
            int y1=queries[i][0]-1;
            int x2=queries[i][3]-1;
            int y2=queries[i][2]-1;
            // Point p1 = new Point(x1,y1);
            // Point p2 = new Point(x2,y1);
            // Point p3 = new Point(x2,y2);
            // Point p4 = new Point(x1,y2);
            int width = x2-x1;
            int heigth = y2-y1;;
            // System.out.println("width : "+width);
            // System.out.println("heigth : "+heigth);
            
            //w좌상단에서 우상단으로 이동
            int savedNum = -1;
           
            for(int j=0; j<width; j++){
               min = Math.min(min,board[x1][y1]);
                
                if(savedNum==-1){
                    savedNum=board[x1+1][y1];
                    
                    board[x1+1][y1]=board[x1][y1];
                    
                }else{
                    int temp= board[x1+1][y1];
                    board[x1+1][y1]=savedNum;
                    min = Math.min(min,savedNum);
                    savedNum=temp;
                }
                x1++;
            }
            
            //우상단에서 우하단 이동
            for(int j=0; j<heigth; j++){
               min = Math.min(min,board[x1][y1]);
                if(savedNum==-1){
                    savedNum=board[x1][y1+1];
                    board[x1][y1+1]=board[x1][y1];
                    
                }else{
                    int temp= board[x1][y1+1];
                    board[x1][y1+1]=savedNum;
                    min = Math.min(min,savedNum);
                    savedNum=temp;
                }
                y1++;
            }
            
             
            //우하단에서 좌하단으로 이동
      
            for(int j=0; j<width; j++){
               min = Math.min(min,board[x1][y1]);
                if(savedNum==-1){
                    savedNum=board[x1-1][y1];
                    board[x1-1][y1]=board[x1][y1];
                    
                }else{
                    int temp= board[x1-1][y1];
                    board[x1-1][y1]=savedNum;
                    min = Math.min(min,savedNum);
                    savedNum=temp;
                }
                x1--;
            }
            
             //좌하단에서 좌상단 이동
            for(int j=0; j<heigth; j++){
               min = Math.min(min,board[x1][y1]);
                if(savedNum==-1){
                    savedNum=board[x1][y1-1];
                    board[x1][y1-1]=board[x1][y1];
                    
                }else{
                    int temp= board[x1][y1-1];
                    board[x1][y1-1]=savedNum;
                    min = Math.min(min,savedNum);
                    savedNum=temp;
                }
                y1--;
            }
            answer[i]=min;
      
            
        }
        
        
        
        
        // 보드 디버깅용
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
               System.out.print(board[j][i]+" ");
            }
             System.out.print("\n");
        }        
        
       
        return answer;
    }
    class Point {
        int x;
        int y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}
