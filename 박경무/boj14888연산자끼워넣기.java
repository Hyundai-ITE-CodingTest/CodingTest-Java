package samsungSW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14888연산자끼워넣기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int MIN = Integer.MAX_VALUE;
	static int MAX = Integer.MIN_VALUE;
	static int[] arr;
	static int[] cal ;
	static int n; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i<n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		cal = new int[4];
		for(int i=0; i<4; i++) {
			cal[i]=Integer.parseInt(st.nextToken());
		}
		dfs(1,arr[0]);
		System.out.println(MAX);
		System.out.println(MIN);
		//
	}
	public static void dfs(int cur, int num) {
		if(cur==n) {
			MAX =Math.max(MAX, num);
			MIN =Math.min(MIN, num);
		}else {
			for(int i=0; i<4; i++) {
				if(cal[i]>0) {
					cal[i]--;
					if(i==0) {
						dfs(cur+1,num+arr[cur]);
					}else if(i==1) {
						dfs(cur+1,num-arr[cur]);
					}else if(i==2) {
						dfs(cur+1,num*arr[cur]);
					}else if(i==3) {
						dfs(cur+1,num/arr[cur]);
					}
					cal[i]++;
				}
			}
		}
	}

}
