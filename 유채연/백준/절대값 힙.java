import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
		
			@Override
			public int compare(Integer o1, Integer o2) {
				int absoluteO1=o1;
				int absoluteO2=o2;
				
				if(o1<0) {
					absoluteO1 = o1 + o1*(-1)*2;
				}
				if(o2<0) {
					absoluteO2 = o2 + o2*(-1)*2;
				}
				
				//절대값 동일한 경우 오름차순
				if(absoluteO1==absoluteO2) {
					return o1-o2;
				}
				//절대값 오름차순
				return absoluteO1-absoluteO2;
			}
		});
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num==0) {
				if(!pq.isEmpty()) {
					System.out.println(pq.poll());
				}else {
					System.out.println(0);
				}
			}else {
				pq.add(num);
			}
		}
	}
}
