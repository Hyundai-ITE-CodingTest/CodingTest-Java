import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        //게임 상황 입력 배열 받기
        Scanner scan = new Scanner(System.in);
        int[][] arr = new int[3][3];
        int count = 0;
        for(int i = 0; i<3; i++){
            for(int j = 0; j< 3; j++){
                arr[i][j] = scan.nextInt();
                if(arr[i][j] != 0) count++;
            }
        }
        //아무것도 놓이지 않은 상황일 때,(반레)
        if(count == 0) System.out.print("D");
        else{
            //착수하는 플레이어가 누구인가? 전체 판에 놓인 개수가 짝수 일경우 1 아닐 경우 2
            int start = 1;
            if(count % 2 != 0) start = 2;
            //착수 결과 출력
            int win = recursive(arr,start);
            if(win == 1) System.out.print("W");
            else if(win == 0) System.out.print("D");
            else System.out.print("L");
        }
    }
    //플레이어가 번갈아 가면서 수를 놓는다 => 재귀 호출
    //이때 내가 먼저 놨는데 상대방이 이긴다면 나는 패이다.
    public static int recursive(int[][] arr, int start){
        int result = 2; //상대방의 승패 정보
        for(int i = 0; i<3; i++){
            for(int j = 0; j< 3; j++){
                if(arr[i][j] == 0){
                    arr[i][j] = start;
                    //플레이어 상황에서 W이 나온 경우 -> 상대가 짐
                    if(Result(arr,start).equals("W")) result = -1;
                    result = Math.min(result, recursive(arr, 3-start)); //1->2 2->1 swap
                    arr[i][j] = 0; //다음 경우의 수로 가기 위함
                }
            }
        }
        if(result == 1) return -1;// 상대방이 이겼을 경우
        //무승부 경우 => 결과가 나오지 않았거나, 더이상 둘 곳이 없을 때
        if(result==0 || result==2) return 0;
        else return 1;
    }
    //플레이어가 이기는 경우의 수
    public static String Result(int[][] arr, int start){//확인하고자 하는 플레이어 명시 필요
        // 가로로 같은 숫자 나열 [(0,0) (0,1) (0,2)], [(1,0) (1,1) (1,2)], [(2,0) (2,1) (2,2)]
        // 세로로 같은 숫자 나열 [(0,0) (1,0) (2,0)], [(0,1) (1,1) (2,1)], [(0,2) (1,2) (2,2)]
        // 대각선 같은 숫자 나열 [(0,0) (1,1) (2,2)], [(0,2) (1,1) (2,0)]
        for(int i =0 ; i < 3; i++){
            if(arr[i][0]==start && arr[i][0]==arr[i][1] && arr[i][1]==arr[i][2]){return "W";}}
        for(int i =0 ; i < 3; i++){
            if(arr[0][i]==start && arr[0][i]==arr[1][i] && arr[1][i]==arr[2][i]){return "W";}}
        if(arr[0][0]==start && arr[0][0]==arr[1][1] && arr[1][1]==arr[2][2]){return "W";}
        if(arr[0][2]==start && arr[0][2]==arr[1][1] && arr[1][1]==arr[2][0]){return "W";}
        return "D";
    }
}
/*
처음 테스트케이스만 고려한 생각에 오답을 받음
1) 아무것도 두지 않은 상황 => 조건 추가 , 2) 빈 공간이 많은 상황 => 플레이어 말(1,2) 지정 필요
*/
