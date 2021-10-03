import java.util.PriorityQueue;

class Solution {
	public int[] solution(String[] operations) {
		PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>();

		for (String cmd : operations) {
			if (cmd.charAt(0) == 'I') {
				// 큐에 숫자 삽입
				int num = Integer.parseInt(cmd.substring(2));
				minQueue.add(num);
				maxQueue.add(num * (-1));
			} else {
				if (!minQueue.isEmpty()) {
					if (cmd.charAt(2) == '-') {
						// 최솟값 삭제
						int tmp = minQueue.poll() * (-1);
						maxQueue.remove(tmp);
					} else {
						// 최댓값 삭제
						int tmp = maxQueue.poll() * (-1);
						minQueue.remove(tmp);
					}
				}
			}
		}
		
		int[] answer = {0, 0};
		
		if(!minQueue.isEmpty())
		{
			answer[0] = maxQueue.peek() * (-1);
			answer[1] = minQueue.peek();
		}

		return answer;
	}
}