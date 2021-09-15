import java.io.*;
import java.util.StringTokenizer;

public class SetExpression {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        //n은 1부터 n까지의 원소 종류
        //m 은 입력 받는 연산 수
        //0이 들어오면 a,b 각각 원소가 포함된 집함에 합친다
        //1이 들어오면 a, b, 원소가 같은 집합인지 확인한다.
        //union-find 알고리즘

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        //초기 부모 값 => 자기 값을 가진다.
        parent = new int[N+1];
        for(int i = 0; i<= N; i++){
            parent[i] = i;
        }
        for(int i = 0; i< M; i++) {
            st = new StringTokenizer(br.readLine());
            int set = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (set == 0) {
                union(a, b);
            } else { // set == 1
                if (find(a) == find(b)) {
                    bw.write("YES\n");
                } else {
                    bw.write("NO\n");
                }
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
    //부모 찾기
    public static int find(int a){
        if(a == parent[a]){//자기 자신이 부모인 경우
            return a;
        }else { //최상위 부모 찾기
            parent[a] = find(parent[a]);
            return parent[a];
        }
    }
    //합집합 관계
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (a < b) {
                parent[b] = a;
            } else {
                parent[a] = b;
            }
        }
    }
}
