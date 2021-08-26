package cod8_26;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Card {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int N = Integer.parseInt(br.readLine());
		
		
		List<Integer> list = new LinkedList<Integer>();
		
		for(int i = 1; i <= N; i++) {
			list.add(i);
		}
		
		while(list.size() != 1) {
			list.remove(0);
			
			list.add(list.get(0));
			
			list.remove(0);
		}
		
		System.out.println(list.get(0));
		
		//bw.flush();
		//bw.close();
		br.close();
		
	}

}
