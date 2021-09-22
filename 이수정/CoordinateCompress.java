import java.io.*;
import java.util.*;

public class CoordinateCompress {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); //5
        String str = br.readLine(); // 2 4 -10 4 -9
        String[] arr = str.split(" ");
        int[] list = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray(); //2, 4, -10, -9
        int[] num = Arrays.stream(arr).distinct().mapToInt(Integer::parseInt).toArray(); //2, 4, -10, -9
        Arrays.sort(num); // -10 -9 2 4
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for(int i : num){
            map.put(i, idx);
            idx++;
        }
        for(int i : list){
            sb.append(map.get(i));
            sb.append(" ");
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}

