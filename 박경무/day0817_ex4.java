package kosa.ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class day0817_ex4 {
	static BufferedReader br= new BufferedReader( new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
//		System.out.println((int)'a');//97
//		System.out.println((int)'z');//122
	String str_pw = br.readLine();
	for (int i = 0; i < str_pw.length(); i++) {
		if((int)(str_pw.charAt(i))+4 >122) {
			sb.append((char)((int)(str_pw.charAt(i))+3-122+97));
		}else
			sb.append((char)((int)(str_pw.charAt(i))+4));
	}
	System.out.println(sb);

	}

}
