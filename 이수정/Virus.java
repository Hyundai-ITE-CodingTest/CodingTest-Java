import java.util.Scanner;
import java.util.Stack;

public class Virus {
    private static int input;
    private static int conn;
    private static int[][] map;
    private static boolean[] visited;
    public static void main(String[] args) {
        //데이터 입력 받기
        Scanner scan = new Scanner(System.in);
        input = scan.nextInt();// 컴퓨터 수 입력
        conn = scan.nextInt();// 연결된 컴퓨터 쌍의 수

        //시작지점과 연결된 컴퓨터의 개수를 구하라
        /*
        1 2, 2 3, 1 5, 5 2, 5 6, 4 7
         */
        map = new int[input+1][input+1];
        visited = new boolean[input+1];
        //visited[1] = true;
        for(int i =0; i< conn; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            map[x][y] = 1;
            map[y][x] = 1;
        }
        scan.nextLine();
        System.out.println(dfs(1));
    }
    public static int dfs(int x){//1 -> 2
        Stack<Integer> stack = new Stack<>(); //인접한 데이터 넣기
        stack.push(x); //1 시작 데이터 넣고 // 2
        visited[x] = true;
        for(int i =0; i< input+1; i++){//0,1,2,3,4,5,6,7
            if(map[x][i] == 1 && visited[i] == false){ //[1][2] [1][5] // [2][1]
                dfs(i); // dfs(2)
            }
        }
        int count = 0;
        for(int i =2; i< input+1; i++){
            if(visited[i] == true){
                count++;
            }
        }
        return count;
    }
}
