import java.io.*;
import java.util.StringTokenizer;

public class 퇴사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] T_arr = new int[N]; int[] P_arr = new int[N];
        T_arr[0] = 0; P_arr[0] = 0;
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T_arr[i] = Integer.parseInt(st.nextToken());
            P_arr[i] = Integer.parseInt(st.nextToken());
        }
        //수익을 저장하는 배열 만들기
        int[] arr = new int[N+1];//마지막 배열의 위치에 누적한 값을 저장
        for(int i = 0; i< N; i++){
            int next_day = i + T_arr[i]; //일자 + 소요시간
            if(next_day <=N){//퇴사일 내에
                //값 비교하여 최대 값 저장
                //상담이 끝난 날에 가서 이전에 상담으로 번 돈(arr[i])와 벌수 있는 돈(p_arr[i])를 더함.
                arr[next_day] = Math.max(arr[next_day], arr[i] + P_arr[i]);
            }
            //건너 뛴 값은 이전의 최대값으로 바꿈
            arr[i+1] = Math.max(arr[i+1], arr[i]);
        }
        System.out.println(arr[N]);
    }
}
