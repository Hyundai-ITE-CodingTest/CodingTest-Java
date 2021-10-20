package samsungSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj13458시험감독 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		long cnt=N;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int major = Integer.parseInt(st.nextToken());
		int minor = Integer.parseInt(st.nextToken());
		for (int i = 0; i < arr.length; i++) {
			arr[i] -=major;
			if(arr[i]>0) {
				if(arr[i]%minor==0) {
					cnt+=(arr[i]/minor);
				}else {
					cnt+=(arr[i]/minor)+1;
				}
			}
		}
		System.out.println(cnt);
		
	}

}
