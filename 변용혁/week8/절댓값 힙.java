package week8;

import java.io.*;
import java.util.*;

public class 절댓값힙_11286 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		PriorityQueue<solution> pq = new PriorityQueue<solution>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				if(pq.size() == 0) {
					bw.write("0");
				}
				else {
					bw.write(String.valueOf(pq.poll().value));
				}
				bw.newLine();
			}else {
				pq.add(new solution(Math.abs(x), x));
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}	
}

class solution implements Comparable<solution> {

	int key;
	int value;
	
	public solution(int key, int value) {
		super();
		this.key = key;
		this.value = value;
	}

	@Override
	public int compareTo(solution target) {
		if(this.key == target.key) {
			return this.value >= target.value? 1: -1;
		}
		return this.key >= target.key ? 1: -1;
	}
	
}
