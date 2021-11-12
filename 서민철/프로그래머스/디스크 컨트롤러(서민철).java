import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
	public class Job {
		public int start, duration;

		public Job(int start, int duration) {
			this.start = start;
			this.duration = duration;
		}
	}

	public int solution(int[][] jobs) {
		int answer = 0;

		// 시작 시간이 빠른 순서대로 내보내주는 우선순위 큐
		PriorityQueue<Job> startFirst = new PriorityQueue<Job>(new Comparator<Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				return o1.start - o2.start;
			}
		});

		for (int[] job : jobs) {
			startFirst.add(new Job(job[0], job[1]));
		}

		// 실행 시간이 짧고, 시간이 빠른 순서대로 내보내주는 우선순위 큐
		PriorityQueue<Job> durationFirst = new PriorityQueue<Job>(new Comparator<Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				if (o1.duration == o2.duration) {
					return o1.start - o2.start;
				}
				return o1.duration - o2.duration;
			}
		});

		// k는 현재 시간
		int k = startFirst.peek().start;

		// 반복이 끝나는 조건은 더 이상 처리할 작업이 없을 때
		while (!startFirst.isEmpty() || !durationFirst.isEmpty()) {
			// durationFirst라는 큐에는 실행 가능한 작업만 들어올 수 있음
			// 실행 가능한 작업이란? 현재 시간(k)보다 시작 시간이 작거나 같은 작업을 의미
			while (!startFirst.isEmpty() && startFirst.peek().start <= k) {
				durationFirst.add(startFirst.poll());
			}

			if (!durationFirst.isEmpty()) {
				// durationFirst에서 가장 작업 시간이 짧고, 시작 시간이 빠른 애를 뽑는다.
				Job task = durationFirst.poll();
				k += task.duration;
				answer += k - task.start;
			} else {
				k = startFirst.peek().start;
			}
		}
		
		return answer / jobs.length;
	}
}