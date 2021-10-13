import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RoboticVaccum {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static {
            st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static int N = Integer.parseInt(st.nextToken()); //세로
    static int M = Integer.parseInt(st.nextToken()); // 가로
    static int[][] arr;
    static int count;

    public static void main(String[] args) throws IOException {
        arr = new int[N][M];

        //로봇청소기가 있는 칸의 좌표(r,c) 바라보는 방향 d
        st = new StringTokenizer(br.readLine());
        int cur_r = Integer.parseInt(st.nextToken());
        int cur_c = Integer.parseInt(st.nextToken());
        //  0: 북쪽을, 1: 동쪽을, 2: 남쪽을, 3: 서쪽
        int d = Integer.parseInt(st.nextToken());

        //장소의 상태 빈칸은 0 벽은 1
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        count = 1;
        dfs(cur_r, cur_c, d);
        System.out.println(count);
    }

    public static void dfs(int x, int y, int d) {
        //이동 방향
        int[] row = {-1, 0, 1, 0}; // 북,동,남,서
        int[] col = {0, 1, 0, -1};

        //로봇청소기가 처음 있는 위치 값은 무조건 0
        arr[x][y] = 2; // 청소가 완료된 곳은 2로 변경

        for (int i = 0; i < 4; i++) { // 이동 방향
            //왼쪽 방향으로 회전: 현재 위치/ 현재 방향 기준으로
            d = d - 1;
            if (d == -1) {
                d = 3;
            }
            //회전하고 전진
            int next_x = x + row[d];
            int next_y = y + col[d];
            //배열의 범위 내에서 탐색
            if (next_x >= 0 && next_y >= 0 && next_x < N && next_y < M) {
                if (arr[next_x][next_y] == 0) { //청소가 필요한 곳이라면
                    count++;
                    dfs(next_x, next_y, d);
                    return;
                }
            }
        }
        //이동할수 없다면? => 후진이 필요한 경우 , 반대 방형으로 변경
        int back_d = -1;
        if (d == 0) {
            back_d = 2;
        }
        if (d == 1) {
            back_d = 3;
        }
        if (d == 2) {
            back_d = 0;
        }
        if (d == 3) {
            back_d = 1;
        }
        int back_x = x + row[back_d];
        int back_y = y + col[back_d];
        if (back_x >= 0 && back_y >= 0 && back_x < N && back_y < M && arr[back_x][back_y] != 1){
            dfs(back_x, back_y, d);
        }
    }
}

