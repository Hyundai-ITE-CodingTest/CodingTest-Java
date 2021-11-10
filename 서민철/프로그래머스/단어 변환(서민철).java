import java.util.*;
import java.io.*;

class Solution {
	boolean[] visited;

	public class Word {
		String word;
		int steps;

		public Word(String word, int steps) {
			this.word = word;
			this.steps = steps;
		}
	}

	public int solution(String begin, String target, String[] words) {
		int answer = 0;
		visited = new boolean[words.length];

		for (boolean v : visited) {
			v = false;
		}

		answer = BFS(begin, target, words);

		return answer;
	}

	// start에서 end로 가기 위한 최소 단계를 반환한다.
	public int BFS(String start, String end, String[] words) {
		Queue<Word> queue = new LinkedList<Word>();
		queue.add(new Word(start, 0));

		while (!queue.isEmpty()) {
			Word w = queue.poll();

			if (w.word.equals(end)) {
				return w.steps;
			}

			for (int i = 0; i < words.length; i++) {
				if (!visited[i] && getDiffNum(w.word, words[i]) == 1) {
					queue.add(new Word(words[i], w.steps + 1));
					visited[i] = true;
				}
			}
		}

		return 0;
	}

	// 문자열 A와 문자열 B의 다른 문자 개수를 확인한다.
	public int getDiffNum(String A, String B) {
		int n = 0;

		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) != B.charAt(i)) {
				n += 1;
			}
		}

		return n;
	}
}