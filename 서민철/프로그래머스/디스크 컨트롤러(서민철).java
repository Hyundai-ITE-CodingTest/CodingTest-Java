import java.util.*;
import java.io.*;

class Solution {
	public int solution(int[][] jobs) {
		int jobSize = jobs.length;

		// 시작 시간이 덜 되서 대기 중인 작업들을 저장한다.
		PriorityQueue<Job> pendingQueue = new PriorityQueue<Job>(new Comparator<Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				return Integer.compare(o1.start, o2.start);
			}
		});

		// 시작 시간은 됐으나, 이전 작업이 처리될 때까지 기다리는 작업들을 저장한다.
		PriorityQueue<Job> processQueue = new PriorityQueue<Job>(new Comparator<Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				if (o1.required == o2.required) {
					return Integer.compare(o1.start, o2.start);
				}
				return Integer.compare(o1.required, o2.required);
			}
		});

		for (int[] time : jobs) {
			Job job = new Job(time[0], time[1]);
			pendingQueue.add(job);
		}

		// 모든 작업들의 대기 시간 총합을 저장한다.
		int sum = 0;

		// 전 작업이 종료된 시간을 저장한다.
		int prev = 0;

		// 두 큐가 모두 비어야 종료된다.
		while (!pendingQueue.isEmpty() || !processQueue.isEmpty()) {
			// processQueue는 비었는데 prev가 작아서 pendingQueue에서 값이 넘어오지 못하는 경우
			if (processQueue.isEmpty() && pendingQueue.peek().start > prev) {
				prev = pendingQueue.peek().start;
				// System.out.printf("pendingQueue에는 %d개 작업이 남아있으나 현재 시각(prev)이 %d이므로 작업을 시작할 수 없음\n", pendingQueue.size(), prev);
			}

			while (!pendingQueue.isEmpty() && pendingQueue.peek().start <= prev) {
				processQueue.add(pendingQueue.poll());
			}

			// System.out.printf("%d에 시작 => ", prev);

			Job job = processQueue.poll();
			// System.out.printf("[%d, %d] => ", job.start, job.required);

			int pending = 0;

			// 추가 대기 시간이 있는가?
			if (prev > job.start) {
				pending += prev - job.start;
			}

			pending += job.required;

			sum += pending;
			prev += job.required;
			// System.out.printf("%d만큼 대기 and %d에 종료\n", pending, prev);
		}

		return sum / jobSize;
	}

	class Job {
		public int start;
		public int required;

		public Job(int start, int required) {
			this.start = start;
			this.required = required;
		}
	}
}