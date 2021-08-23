import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//순열 구하기 => 재귀함수 + 중복을 허용하지 않음
public class Sequence02 {
    static int N, M;
    static int[] arr;
    static boolean[] visited; //인덱스로 방문 확인 여부 확인

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //1부터 N까지
        M = Integer.parseInt(st.nextToken());// M개 고르기
        arr = new int[M];
        visited = new boolean[N]; //4
        recursive(0);
    }
    public static void recursive(int index){
        //base code
        if(index == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        //recursive code
        for (int i = 0; i < N; i++){ //0, 1, 2, 3
            if(visited[i] == false) {//방문한적 없을 경우
                visited[i] = true; // 방문한 것으로 바꾸고
                arr[index] = i+1; // 값 넣어주고
                recursive(index + 1); //재귀
                //현재 위치보다 앞의 것은 제외함
                for(int j = i+1; j < N; j++){
                    visited[j] = false;
                }

            }
        }
    }
}

