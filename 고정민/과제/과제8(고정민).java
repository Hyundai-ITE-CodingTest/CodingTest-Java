package day0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*brain의 타입을 deque로 바꿔서 다시 작성해보기 */

public class MemorizeWords {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); // 공백 구분을 위한 StringTokenizer

		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		String str = br.readLine();
		String[] word = str.split(" ");
		int time = 0;
		List<String> brain = new ArrayList<String>();

		for (int i = 0; i < word.length; i++) {
			if (brain.size() < n) { // 뇌용량이 다 차지 않았다면
				if (brain.contains(word[i])) {// 근데 뇌에 단어가 있다면 1초 추가
					time += 1;
					brain.remove(word[i]);
					brain.add(word[i]);
				} else { // 뇌에 단어가 없으면 3초 추가+단어를 뇌에 추가
					time += 3;
					brain.add(word[i]);
				}
			} else if (brain.size() == n) { // 뇌용량이 다 찼어
				if (brain.contains(word[i])) {// 근데 뇌에 단어가 있다면 1초 추가
					time += 1;
					brain.remove(word[i]);
					brain.add(word[i]);
				} else {// 3초증가, 뇌에 담겨있는 단어들의 평균길이 계산후 새로운 단어의 길이를 비교
					time += 3;
					int k = 0;
					int total = 0;
					for (String s : brain) {
						total += s.length();
					}
					while (brain.get(k).length() > (total / n)) {
						k++;
					}
					brain.remove(k);
					brain.add(word[i]);
				}
			}

		}
		System.out.println();
		System.out.println(time);
	}
}
