import java.util.*;

//영역 : 상하좌우로 연결된 같은 색상의 공간
//result : 몇개의 영역, 가장 큰 영역의 넓이 

//상하좌우 좌표 개념 Point
class Point{
    int x, y;
    public Point(int x, int y){
        this.x = x;
        this.y =y;
    }
}

class Solution {
    //영역의 수 출력
    public static int BFS(boolean[][] visited, int[][] picture, Point start){ //start Point 객체 생성
        //좌,우,상,하
        int[] dx = {-1, 1, 0, 0}, dy ={0,0,1,-1};
        //영역의 초기 값은 1
        int area = 1;
        int nx, ny;
        //시작 좌표
        visited[start.x][start.y] = true;
        //위치 좌표를 기억하는 큐 선언
        Queue<Point> q = new LinkedList<>();
        //객체 삽입
        q.add(start);
        while(!q.isEmpty()){
            //가장 앞에 있는 좌표를 저장후 큐에는 삭제
            Point cur = q.poll();
            for(int i =0; i< 4; i++){
                //현재 좌표의 위치에서 탐색 방향순으로 다음 위치 값 저장
                nx = dx[i] + cur.x;
                ny = dy[i] + cur.y;
                //탐색 범위 내에서
                if(0 <= nx && nx < picture.length &&0 <=ny && ny < picture[0].length){
                    //방문하지 않았고, 0이 아니고, 현재 값과 다음 값이 동일(같은 색)
                    if(visited[nx][ny] == false && picture[nx][ny] != 0 &&
                            picture[cur.x][cur.y] == picture[nx][ny]){
                        //방문한 것으로 변경하고
                        visited[nx][ny] = true;
                        //위치 저장하고
                        q.add(new Point(nx, ny));
                        //영역 넓이 증가
                        area++;
                    }
                }
            }
        }
        return area;
    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 1;
        //정답 배열 : 몇개 영역, 가장 큰 영역 넓이
        int[] answer = new int[2];
        //방문 했는지 check, 초기값 false
        boolean[][] visited = new boolean[m][n];

        for(int x = 0; x<m ; x++){
            for(int y =0 ; y< n; y++){
                //색칠이 되어 있는 영역, 방문하지 않은 곳
                if(visited[x][y] == false && picture[x][y] !=0){
                    //가장 큰 영역인가? => max 함수 사용.
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, BFS(visited, picture, new Point(x,y)));
                    //몇개 영역인지
                    numberOfArea++;
                }
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
