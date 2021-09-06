package team3.day3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class boj11650좌표정렬하기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		List<Point> list = new ArrayList();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) ));
		}
		
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for(Point p : list) {
			sb.append(p.x).append(" ").append(p.y).append("\n");
		}
		System.out.print(sb);
	}
	
}

class Point implements Comparable<Point> {
	int x;
	int y;
	Point(int x, int y) {
		this.x = x;
		this.y= y;
	}
	
	@Override
	public int compareTo(Point p) {
		if(this.x>p.x) {
			return 1;
		}else if(this.x==p.x) {
			if(this.y>p.y) {
				return 1;
			}else if(this.y<p.y) {
				return -1;
			}else {
				return 0;
			}
		}
		return -1;
	}
}
