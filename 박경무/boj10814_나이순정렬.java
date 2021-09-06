package team3.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj10814_나이순정렬 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		Member[] arr = new Member[N];
		List<Member> list= new ArrayList();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Member(Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(list.get(i).age).append(" ").append(list.get(i).name).append("\n");
		}
		System.out.print(sb);
	}

}

class Member implements Comparable<Member>{
	int age;
	String name;
	
	Member(int age, String name){
		this.age = age;
		this.name = name;
	}
	@Override
	public int compareTo(Member p) {
		if(this.age > p.age) {
			return 1;
		}else if(this.age <p.age){
			return -1;
		}
		return 0;
	}


	}