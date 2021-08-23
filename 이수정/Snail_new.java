import java.io.*;
/*
* 이전 Snail 코드는 백준 사이트에서 메모리 초과가 나타났음.
* 이중 for문이 문제인줄 알았지만, 입출력 문제임을 피드백 받음.
*/
public class Snail_new {
    public static void main(String[] args) throws IOException {
        //홀수 자연수만 들어오는 조건을 명시함
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = 0;
        while (true){
            int input = Integer.parseInt(bf.readLine());
//            int input = scan.nextInt();
            if(input % 2 == 1){
                N = input;
                break;
            }else{
                System.out.println("짝수를 입력하실 수 없습니다.");
            }
        }
        //입력 받은 자연수에 따른 표를 만든다.
        int[][] arr = new int[N][N];
        int max_value = N*N; //시작 값
        int row = -1; int col = 0;
        int swap = 1; // 방향 2가지 분류 +1 걍우, -1 경우로 2번씩 반복됨
        int count = N; //인풋되는 좌표를 겹치지 않기 위해

        for(int i=count; i>0; i--) {//5 4 3 2 1
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
                bw.write(String.valueOf(arr[i][j])+" ");
            }
            bw.newLine();
        }
        //===========위치 좌표구하기===================
        int find = Integer.parseInt(bf.readLine());
        for(int i = 0; i< N; i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j] == find){
                    bw.write(String.valueOf(i+1) +" "+String.valueOf(j+1)); //괄호를 안해주니 문자열로 들어감
                }
            }
        }
        bf.close();
        bw.flush();
        bw.close();
    }
}
