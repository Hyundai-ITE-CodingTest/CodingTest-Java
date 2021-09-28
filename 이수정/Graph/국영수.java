import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb  = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[][] arr = new String[N][4];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            arr[i] = str.split(" ");
        }
        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (Integer.valueOf(o1[1]) > Integer.valueOf(o2[1])) { // 국어가 감소하는 순으로
                    return -1;
                } else if (Integer.valueOf(o1[1]) == Integer.valueOf(o2[1])) { // 국어 동일
                    if (Integer.valueOf(o1[2]) == Integer.valueOf(o2[2])) { // 영어 동일
                        if (Integer.valueOf(o1[3]) == Integer.valueOf(o2[3])) { // 수학 동일
                            return o1[0].compareTo(o2[0]); // 사전식 정렬
                        }
                        return Integer.compare(Integer.valueOf(o2[3]), Integer.valueOf(o1[3]));
                    }
                    return Integer.compare(Integer.valueOf(o1[2]), Integer.valueOf(o2[2]));
                }
                else return 1; // 모든 경우에 걸리지 않으면 기존상태 유지
            }
        });
        for(int i = 0 ; i < N; i++){
            sb.append(arr[i][0]);
            sb.append("\n");
        }
        System.out.println(sb);

    }
}

