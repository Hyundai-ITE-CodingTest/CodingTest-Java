package kosa.ex3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class day0820ex2 {
	
	static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	static int sum, cnt;
	static boolean sharp;
	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			char now = str.charAt(i);
			// 올라가면 cnt ++;
			if(now == '(') {
				cnt++;
				if(sharp) {
					sum += 2*cnt;
				}else {
					sum +=cnt;
				}
				// 내려가면 cnt --;
			}else if(now == ')') {
				if(sharp) {
					sum += 2*cnt;
				}else {
					sum +=cnt;
				}
				cnt--;
				//# 이 나오면 boolean 토글
			}else if(now == '#') {
				sharp =!sharp;
			}
		}
		//출력
		System.out.println(sum);
	}
//((#(())#(())))
}
