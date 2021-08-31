package team3.day3;
import java.io.*;
import java.util.*;


public class boj6603로또 {
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		while(true) {
			String str = br.readLine();
			if(str.equals("0")) {
				System.out.println(sb);
				return;
			}
			StringTokenizer st = new StringTokenizer(str);
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			int[] result = new int[6];
//			boolean[] visited= new boolean[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			comb(0,arr,result,0);
			sb.append("\n");
		}
	}
	
	static void comb(int cur, int[] arr, int[] result, int start) {
		if(cur==6) {
			for (int i = 0; i < result.length; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
		}else {
			for (int i = start; i < arr.length; i++) {
				result[cur]=arr[i];
				comb(cur+1,arr,result,i+1);
			}
		}
	}
}
