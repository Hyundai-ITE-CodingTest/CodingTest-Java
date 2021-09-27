package week10;

import java.io.*;
import java.util.*;

public class 국영수_10825 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Score> pq = new PriorityQueue<Score>(new Comparator<Score>() { //우선 순위 큐
			@Override
			public int compare(Score o1, Score o2) {
				if (o1.ko != o2.ko) {
					return o2.ko - o1.ko; //내림차순
				} else if (o1.en != o2.en) {
					return o1.en - o2.en; //오름차순
				} else if (o1.ma != o2.ma) {
					return o2.ma - o1.ma; //내림차순
				} else {
					return o1.name.compareTo(o2.name); //오름차순
				}
			}
		});

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int ko = Integer.parseInt(st.nextToken());
			int en = Integer.parseInt(st.nextToken());
			int ma = Integer.parseInt(st.nextToken());

			pq.add(new Score(name, ko, en, ma));
		}

		while (pq.size() > 0) { //정렬순서대로 poll하면서 write
			Score s = pq.poll();
			bw.write(s.name);
			bw.newLine();
		}

		bw.flush();
		bw.close();
		br.close();
	}
}

class Score {
	int ko;
	int en;
	int ma;
	String name;

	public Score(String name, int ko, int en, int ma) {
		this.ko = ko;
		this.en = en;
		this.ma = ma;
		this.name = name;
	}

}
