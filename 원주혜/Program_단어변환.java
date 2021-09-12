
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Program_단어변환 {

	static Queue<String> queue = new LinkedList<String>();
	static HashMap<String, ArrayList<String>> graph = new HashMap<>();
	static HashMap<String, Boolean> visited = new HashMap<String, Boolean>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };

		solution(begin, target, words);
	}

	public static int solution(String begin, String target, String[] words) {
		ArrayList<String> wordlist = new ArrayList<String>(Arrays.asList(words));
		// graph 초기화
		makeGraph(wordlist);
		// visited 초기화
		for (String string : wordlist) {
			visited.put(string, false);
		}
		
		if (!wordlist.contains(target)) {
			System.out.println("0");
			return 0;
		}

		// 한글자 바꾼 단어들 큐에 넣기
		for (int i = 0; i < wordlist.size(); i++) {
			String cur = wordlist.get(i);
			if (getDiffCharNum(cur, begin) == 1) {
				queue.add(cur);
			}
		}

		int answer = bfs(wordlist, target);
		System.out.println("answer " + answer);
		return answer;
	}

	public static int getDiffCharNum(String str1, String str2) {
		int answer = 0;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				answer++;
			}
		}
		return answer;
	}

	public static void makeGraph(List<String> words) {
		for (int i = 0; i < words.size(); i++) {
			String key = words.get(i);
			graph.put(key, new ArrayList<String>());

			for (int j = 0; j < words.size(); j++) {
				if (i == j)
					continue;
				String compareWord = words.get(j);

				if (getDiffCharNum(key, compareWord) == 1) {
					ArrayList<String> values = graph.get(key);
					values.add(compareWord);
					graph.put(key, values);
					visited.put(key, true);
				}
			}
		}
	}

	public static int bfs(List<String> words, String target) {

		int depth = 1;

		while (queue.size() > 0) {

			int curSize = queue.size();

			while (curSize > 0) {
				String curWord = queue.poll();
				--curSize;
				if (visited.get(curWord))
					continue;
				//System.out.println("curWord " + curWord);

				if (curWord.equals(target)) {
					//System.out.println("cog depgth " + depth);
					return depth;
				}

				ArrayList<String> diffOne = graph.get(curWord);

				for (int i = 0; i < diffOne.size(); i++) {
					String nextWord = diffOne.get(i);
					if (!visited.get(nextWord)) {
						queue.add(nextWord);
						visited.put(curWord, true);
					}
				}
			}
			++depth;
		}
		return 0;
	}

}
