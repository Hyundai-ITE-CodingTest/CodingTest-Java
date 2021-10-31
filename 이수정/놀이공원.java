import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 놀이공원 {
    //N명의 학생 -> 한줄로
    //1인승 놀이기구
    //M종류의 놀이기구 (1부터~M까지)
    //줄의 마지막 아이가 타게 되는 놀이기구의 번호
    //데이터 범위가 크다 -> 이분탐색
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] times = new int[M];
        for(int i = 0; i < M; i++){
            times[i] = Integer.parseInt(st.nextToken());
        }
        long left = 1;
        long right = 2000000000L * 30L; //입려 조건이 20억이 넘고 놀이기구 범위가 최대 30임
        long mid = 0;
        //N < M 일경우는 무조건 N
        if( N <= M){
            System.out.println(N);
        } else {
            //22명 5개 놀이기구
            //초기 놀이기구 수만큼 인원수
            //1분 1/1 = 1 1/2 =0..
            //1분으로 22명은 최대 22분 5분으로 22명은 4
            while (left <= right) {
                //System.out.println(right);
                mid = (left + right) / 2;
                long count = M;
                for (int i = 0; i < M; i++) {
                    count += mid / times[i];
                }
                if (count < N) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        long cnt = M;
        for (int i = 0; i < M; i++){
            cnt += (left-1) / times[i];
        }
        for (int i = 0; i < M; i++) {
            if (left % times[i] == 0) {
                cnt++;
            } else {
                continue;
            }
            if (cnt == N) {
                System.out.println(i+1);
            }
        }
    }
}
