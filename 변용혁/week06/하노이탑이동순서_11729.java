package week06;

import java.io.*;

public class 하노이탑이동순서_11729 {
	static BufferedWriter bw;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		bw.write(String.valueOf((int)Math.pow(2, N) - 1));
		bw.newLine();
		
		Solution(N,1,2,3);
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void Solution(int n, int p1, int p2, int p3) throws Exception {
		if(n == 1) {
			bw.write(String.valueOf(p1) + " " + String.valueOf(p3));
			bw.newLine();
			return;
		}else {
			Solution(n-1,p1,p3,p2); //n-1까지 1번기둥 -> 2번기둥
			bw.write(String.valueOf(p1) + " " + String.valueOf(p3)); //n번째를 1번기둥 -> 3번기둥
			bw.newLine();
			Solution(n-1,p2,p1,p3); //2번기둥에 있는거 -> 3번기둥
		}		
	}
}
