package team3.day3;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1182부분수열의합_2번째 {
	static int N, S,cnt;
	static int[] arr;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr= new int[N];
		int total = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			total += arr[i];
		}
		
		for (int i = 1; i <=N; i++) {
			int result=0;
//			java.util.List<Integer> result = new ArrayList();
//			int [] result = new int [i];
			
			comb(i,0,result,0);
			//몇개뽑을지, 지금 몇개 뽑았는지, 총합이 몇인지, 시작인덱스는 어디인지
		}
//		if(N%2==1) {
//			comb(3,0,0,0);
//		}
		System.out.println(cnt);
	}
	static void comb(int r, int cur, int result, int start) {
		if(r==cur) {
//			System.out.println(result);
			if(result==S) {
				cnt++;
			}
		}else {
			for (int i = start; i < arr.length; i++) {
				
				result += arr[i];
				comb(r,cur+1,result,i+1);
				result -= arr[i];
			}
		}
		
		
	}
}
