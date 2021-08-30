package week05;

import java.io.*;
import java.util.*;

public class 랜선자르기_1654 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		long max = 0;
		
		int[] line = new int[K];
		for(int i=0; i<K; i++) {
			line[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, line[i]);
		}
		
		
		long left = 1; // 랜선의 길이가 int 범위인데 왜 long으로 해야할까?
		long right = max;
		
		while(left <= right) {
			long mid = (left + right) / 2; //두 값을 더하면서 int 범위를 벗어날 수 있다.
			long cut = 0;
			
			for(int i=0; i<K; i++) {//cut = mid 길이로 했을때 나오는 랜선의 갯수
				cut += (int)(line[i] / mid);
			}
			if(cut >= N) {
				left = mid + 1;
			}else{
				right = mid - 1;
			}
		}
		
		bw.write(String.valueOf(right));
		bw.flush();
		bw.close();
		br.close();
	}
}
