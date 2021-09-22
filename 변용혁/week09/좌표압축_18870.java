package week08;

import java.io.*;
import java.util.*;

public class 좌표압축_18870 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> answer = new ArrayList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			list.add(temp);
			answer.add(temp);
		}
		
		Collections.sort(list);
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int cnt = 0;
		
		for(Integer l : list) {
			if(!map.containsKey(l))
				map.put(l, cnt++);
		}
		
		for(int i=0; i<N; i++) {
			sb.append(map.get(answer.get(i))).append(" ");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
