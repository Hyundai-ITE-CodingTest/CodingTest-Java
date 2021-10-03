import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class DimensionTomato {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //상자의 가로 세로 높이
    static StringTokenizer st;
    //StringTokenizer 전역변수 사용시 예외 처리
    static {
        try {
            st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int M = Integer.parseInt(st.nextToken());
    static int N = Integer.parseInt(st.nextToken());
    static int H = Integer.parseInt(st.nextToken());

    public static void main(String[] args) throws IOException {

        //토마토 상자에 정보 담기
        int[][][] arr = new int[N][M][H];
        int count = 0;
        while(count < H){
            for(int i = 0; i < N ; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++){
                    arr[i][j][count] = Integer.parseInt((st.nextToken()));
                }
            }
            count++;
        }
        System.out.println(BFS(arr));
    }
    public static int BFS(int[][][] arr){
        int count = 0;
        //토마토 이동 방향 저장 -> 좌표 -> point 사용
        int[] row = {1, -1, 0, 0, 0 ,0}; //오른쪽, 왼쪽, 아래 , 위 , 앞, 뒤
        int[] col = {0, 0, -1, 1, 0, 0};
        int[] height = {0, 0, 0, 0, 1, -1};

        //토마토가 들어 있는 위치 저장
        LinkedList<Point_2> queue = new LinkedList<>();
        while(count < H){
            for(int i = 0; i< N; i++){
                for(int j = 0; j < M; j++){
                    if(arr[i][j][count] == 1){
                        queue.add(new Point_2(i, j, count));
                    }
                }
            }
            count++;
        }

        while(!queue.isEmpty()){
            Point_2 p = queue.remove(); // 맨 첫번째 토마토의 위치
            int x = p.x; int y = p.y; int h = p.h;
            for(int i = 0; i < 6 ; i++){
                //다음 토마토 위치 확인
                int next_x = x + row[i]; int next_y = y + col[i]; int next_h = h + height[i];
                if(next_x >= 0 && next_x < N && next_y >=0 && next_y < M &&
                        next_h >=0 && next_h < H){// 배열 인덱스 범위 안
                    if(arr[next_x][next_y][next_h] == 0){ // 익지 않은 토마토가 있는 경우
                        queue.add(new Point_2(next_x, next_y, next_h)); //큐에는 위치를 저장하고
                        arr[next_x][next_y][next_h] = arr[x][y][h] + 1; //토마토의 위치에는 소요되는 일수를 저장
                    }
                }
            }
        }
        count = 0; // 높이 초기화
        int day = 0;
        while(count < H){
            for(int i = 0; i < N; i ++){
                for(int j = 0; j < M; j++){
                    if(arr[i][j][count] == 0 ){
                        return -1;
                    }else {
                        day = Math.max(arr[i][j][count], day);//토마토 저장 위치에 소요된 일수를 저장 했고 그중 가장 큰 값을 반환
                    }
                }
            }
            count++;
        }
        if(day == 1){ /// 모든 토마토가 익어 있으면
            return 0;
        }else { //토마토가 모두 익지 못하는 경우
            return day -1;
        }
    }
}
//이동 방향 저장
class Point_2{
    int x; int y; int h;
    Point_2(int x, int y, int h){
        this.x = x;
        this.y = y;
        this.h = h;
    }

}
