import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        //첫 줄에는 상자의 크기를 나타내는 두 정수 M,N이 주어진다
        //1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); int N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            String[] arr = str.split(" ");
            int row = 0;
            for(String s: arr) {
                map[i][row++] = Integer.parseInt(s);
            }
        }
        System.out.println(BFS(map));
    }
    static int BFS(int[][] map){
        int N = map.length;
        int M = map[0].length;

        //큐를 사용하여 나아가는 노드(위치)를 넣는다. => 배열을 넣을 수 있다.
        LinkedList<Point> queue = new LinkedList<>();
        //토마토가 있는 1의 위치를 큐에 삽입
        for(int i = 0; i < N; i++){
            for(int j = 0 ; j < M; j++){
                if(map[i][j] == 1){
                    queue.add(new Point(i, j));
                }
            }
        }
        //토마토 이동
        int[] row = {1, -1, 0, 0}; //오른쪽, 왼쪽
        int[] col = {0, 0, -1, 1};// 아래 위

        while(!queue.isEmpty()) {// 큐에 값이 있는 동안
            Point p = queue.remove(); // 첫번째 값을 제거한 큐를 p 객체로 선언
            int x = p.x;
            int y = p.y;
            for (int i = 0; i < 4; i++) {// 이동하는 경우의 수
                int next_x = x + row[i]; // 이동
                int next_y = y + col[i]; // 이동
                //배열 범위 지정 필요
                if (next_x >= 0 && next_x < N && next_y >= 0 && next_y < M) {
                    if (map[next_x][next_y] == 0) {
                        queue.add(new Point(next_x, next_y));
                        map[next_x][next_y] = map[x][y] + 1;
                    }
                }
            }
        }
        int day_count = -2;
        for(int i = 0; i < N; i++){
            for(int j = 0 ; j < M; j++){
                if(map[i][j] == 0){
                    return -1;
                }else {
                    day_count =  Math.max(map[i][j],day_count);
                }
            }
        }
        if(day_count == 1){
            return 0;
        }else {
            return day_count - 1;
        }
    }
}
//좌표 문제일 경우 좌표를 따로 지정하자
class Point{
    int x; int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
