import java.io.*;
/* 하노이의 대표적인 규칙: 가장 큰 판이 도달점까지 가기 위해서
이전의 것들이 도달점 외의 장소에서 먼저 만들어 져야함.
총 이동 횟수: 2^N -1
 */
public class HanoiTower {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        //첫번째 장대에 쌒인 원판의 개수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = (int) Math.pow(2,N)-1;
        bw.write(count + "\n");
        //하노이 -> 재귀
        recursive(N, 1, 2, 3);
        br.close();
        bw.flush();
        bw.close();
        }
    public static void recursive(int N, int from, int mid, int to) throws IOException{
        //base code
        if(N == 1){
            bw.write(from +" "+ to+"\n");
            return;
        }else{
            //N-1개의 판을 1에서 2로 이동
            recursive(N - 1, from, to, mid);
            bw.write( from+" "+ to+"\n");
            //N-1개의 판을 2에서 3으로 이동
            recursive(N - 1, mid, from, to);
        }

    }
}
