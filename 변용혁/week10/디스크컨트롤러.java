package week10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 디스크컨트롤러 {
	public static int solution(int[][] jobs) {
		int answer = 0;

		Arrays.sort(jobs, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1]; // 소요시간순 정렬
			}
		});

		List<int[]> Ljobs = new ArrayList<int[]>();

		for (int[] job : jobs) {
			Ljobs.add(job);
		}

		int start = 0;
		int len = Ljobs.size();

		while (Ljobs.size() != 0) {
			for (int i = 0; i < Ljobs.size(); i++) {
				if (Ljobs.get(i)[0] <= start) {
					start += Ljobs.get(i)[1];
					answer += start - Ljobs.get(i)[0];
					Ljobs.remove(i);
					break;
				}
				
				if(i == Ljobs.size()-1)
					start += 1;
			}
		}

		return answer / len;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 0, 3 }, { 1, 9 }, { 2, 6 } }));
	}
}
