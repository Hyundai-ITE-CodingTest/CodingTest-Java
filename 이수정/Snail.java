import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*백준에서 메모리 초과 문제를 해결하지 못했다..*/
public class Snail_new {
    public static void main(String[] args) throws IOException {
        //홀수 자연수만 들어오는 조건을 명시함
//        Scanner scan = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int find = Integer.parseInt(bf.readLine());
        bf.close();
        //입력 받은 자연수에 따른 표를 만든다.
        int[][] arr = new int[N][N];
        int max_value = N*N; //시작 값
        int row = -1; int col = 0;
        int swap = 1; // 방향 2가지 분류 +1 걍우, -1 경우로 2번씩 반복됨
        int count = N; //인풋되는 좌표를 겹치지 않기 위해
        while(max_value > 0){
            for (int j = 0; j < count; j++) { // 0 1 2 3 4
                row += swap; //0, 1, 2, 3, 4 | // 3 2 1 0
                arr[row][col] = max_value; // 0,0
                max_value--;
            }
            count--; // 4 3
            for (int j = 0; j < count; j++) { //0,1,2,3 | 0 1 2
                col += swap; //1 /
                arr[row][col] = max_value; //41 42 43 44 //03 02 01
                max_value--;
            }
            swap *= -1; // -1, 1, -1, 1
        }
        //==============배열 출력=====================
        for(int i = 0; i< N; i++){
            for(int j = 0; j < N; j++){
                System.out.printf(arr[i][j]+" ");
            }
            System.out.println();
        }
        //===========위치 좌표구하기===================
        for(int i = 0; i< N; i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j] == find){
                    System.out.println(i+1 + " "+(j+1)); //괄호를 안해주니 문자열로 들어감
                }
            }
        }

    }
}
