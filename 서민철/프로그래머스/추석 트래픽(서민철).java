import java.util.*;
import java.io.*;

class Solution {
	public int solution(String[] lines) {
		int answer = 0;
		int[] timing = new int[lines.length * 2];

		PriorityQueue<Log> endFirst = new PriorityQueue<Log>(new Comparator<Log>() {
			@Override
			public int compare(Log l1, Log l2) {
				if (l1.end == l2.end) {
					return Integer.compare(l1.start, l2.start);
				}
				return Integer.compare(l1.end, l2.end);
			}
		});
		PriorityQueue<Log> startFirst = new PriorityQueue<Log>(new Comparator<Log>() {
			@Override
			public int compare(Log l1, Log l2) {
				if (l1.start == l2.start) {
					return Integer.compare(l1.end, l2.end);
				}
				return Integer.compare(l1.start, l2.start);
			}
		});

		int idx = 0;

		for (String line : lines) {
			Log log = setLogTime(line);
			startFirst.add(log);
			timing[idx] = log.start;
			timing[idx + 1] = log.end;
			idx += 2;
		}

		Arrays.sort(timing);

		for (int i : timing) {
			// System.out.printf("현재 시간: %s\n", getTime(i));

			if (i >= 86400000) {
				break;
			}

			while (!endFirst.isEmpty() && endFirst.peek().end < i) {
				// System.out.printf("퇴출: %s\n", endFirst.peek().toString());
				endFirst.poll();
			}

			int limitTime = i + 999;
			// System.out.printf("가용 시간: %s\n", getTime(limitTime));

			while (!startFirst.isEmpty() && startFirst.peek().start <= limitTime) {
				// System.out.printf("진입: %s\n", startFirst.peek().toString());
				endFirst.add(startFirst.poll());
			}

			// System.out.printf("현재 사이즈: %d\n\n", endFirst.size());

			answer = Math.max(answer, endFirst.size());
		}

		return answer;
	}

	public class Log {
		int start, end;

		public Log(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "Start: " + getTime(this.start) + "\tEnd: " + getTime(this.end);
		}
	}

	public Log setLogTime(String time) {
		int start = 0;
		int end = 0;

		time = time.substring(11);
		String[] tmp = time.split(" ");

		String[] endTime = tmp[0].split(":");
		end += Integer.parseInt(endTime[0]) * 60 * 60 * 1000;
		end += Integer.parseInt(endTime[1]) * 60 * 1000;
		end += (int) (Double.parseDouble(endTime[2]) * 1000);

		String[] runTime = tmp[1].split("s");
		start = end;
		start -= (int) (Double.parseDouble(runTime[0]) * 1000);
		start += 1;

		return new Log(start, end);
	}

	public String getTime(int n) {
		int hour = n / (60 * 60 * 1000);
		n %= 60 * 60 * 1000;
		int min = n / (60 * 1000);
		n %= 60 * 1000;
		int sec = n / 1000;
		n %= 1000;
		int milsec = n;

		return String.valueOf(hour) + ":" + String.valueOf(min) + ":" + String.valueOf(sec) + "."
				+ String.valueOf(milsec);
	}
}