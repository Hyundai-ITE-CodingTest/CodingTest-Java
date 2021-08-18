package homework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P4 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		String[] words = bf.readLine().split(" ");

		int totalTime = 0;
		ArrayList<String> memory = new ArrayList<>();

		// 단어 목록에서 하나씩 꺼내면서 비교
		for (int i = 0; i < words.length; i++) {
			if (!memory.contains(words[i])) { // 암기하고 있지 않은 단어라면
				if (memory.size() < n) { // 빈자리가 있다면
					memory.add(words[i]);
					totalTime += 3;
				} else { // 빈자리가 없다면
					int avgMemoryWords = 0; // 외우고 있는 단어 평균 길이
					for (String mWord : memory)
						avgMemoryWords += mWord.length();
					avgMemoryWords /= n; // memory 크기로 나눔

					// 오래된 순서부터
					for (int j = 0; j < memory.size(); j++) {
						if (memory.get(j).length() <= avgMemoryWords) {
							memory.remove(j);
							memory.add(words[i]);
							totalTime += 3;
							break;
						}
					}
				}
			} else { // 암기하고 있는 단어라면
				memory.remove(memory.indexOf(words[i])); // 지우고 다시 새로 추가
				memory.add(words[i]);
				totalTime++;
			}
		}

		System.out.println(totalTime);
	}
}
