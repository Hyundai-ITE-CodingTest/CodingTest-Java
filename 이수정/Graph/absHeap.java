import java.io.*;
import java.util.*;

public class absHeap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        //힙: 최솟값 최댓값 빠르게 찾기 위한 완전이진트리 형태
        //PriorityQueue : 우선순위가 높은 엘리먼트가 먼자 나가는 자료구조
        //Comparator : 인터페이스 ,compare(T o1, T o2) 두개의 객체 비교
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {//선, 후
                int abs1 = Math.abs(o1);
                int abs2 = Math.abs(o2);
                if (abs1 != abs2) {
//                     if (abs1 < abs2) return -1; // 음수
//                     else return 1; // 양수
                    return abs1 - abs2;
                } else {//절대값이 동일할 때,
                    if (o1 < o2) return -1; //음수
                    else return 1; //양수
                }
            }
        });
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (queue.isEmpty()) {
                    //System.out.println("0");
                    bw.write("0\n");
                } else {
                    //System.out.println(queue.poll());
                    bw.write(queue.poll()+"\n");
                }
            } else {
                queue.add(x);
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
