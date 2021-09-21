import java.io.*;
import java.util.*;

public class WordSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        //============= 값 추가=========================
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            String s = "";
            s = br.readLine();
            map.put(s, s.length());
            }
        //============= 문지열 비교=========================
        List<String> list1 = new LinkedList<>(map.keySet());
        list1.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });
        //================출력========================
        for(String s : list1){
            System.out.println(s);
        }
    }
}
