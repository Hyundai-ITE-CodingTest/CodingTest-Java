package week10;

import java.util.*;

public class 이중우선순위큐 {
	public static int[] solution(String[] operations) {

		int[] answer = new int[2];

		PriorityQueue<Integer> minq = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		for (String operation : operations) {
			StringTokenizer st = new StringTokenizer(operation, " ");
			String comm = st.nextToken();
			int num = Integer.parseInt(st.nextToken());

			if (comm.equals("I")) {
				minq.add(num);
				maxq.add(num);
			} else if (comm.equals("D") && minq.size() > 0 && maxq.size() > 0) {
				if (num == 1) {
					int temp = maxq.poll();
					minq.remove(temp);
				} else if (num == -1) {
					int temp = minq.poll();
					maxq.remove(temp);
				}
			}

		}

		if (minq.size() > 0 && maxq.size() > 0) {
			answer[0] = maxq.poll();
			answer[1] = minq.poll();
		}

		return answer;
	}

	public static void main(String[] args) {
//		int[] answer = solution(new String[] {"I 16","D 1"});
		int[] answer = solution(new String[] { "I 7", "I 5", "I -5", "D -1" });
		System.out.println(answer[0] + ", " + answer[1]);
	}
}
