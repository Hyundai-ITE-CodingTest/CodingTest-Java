package week08;

import java.awt.Point;
import java.io.*;
import java.util.*;

public class 좌표정렬하기_11650 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Point> pq = new PriorityQueue<Point>(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if(o1.x != o2.x)
					return o1.x - o2.x;
				else
					return o1.y - o2.y;
			};
		});
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());		
			
			pq.add(new Point(x,y));
		}
		
		while(pq.size() > 0) {
			Point p = pq.poll();
			bw.write(p.x + " " + p.y);
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
