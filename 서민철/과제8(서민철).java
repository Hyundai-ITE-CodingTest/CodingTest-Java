import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		Integer N = Integer.parseInt(st.nextToken());
		Integer W = Integer.parseInt(st.nextToken());

		// 최대 용량이 N개로 제한되어 있는 뇌 역할
		LinkedList<String> brain = new LinkedList<String>();
		// 아는 단어인가를 알려줄 set
		HashSet<String> dict = new HashSet<String>();

		st = new StringTokenizer(br.readLine(), " ");
		Integer answer = 0;
		// 암기한 단어들 길이의 총합
		int sumOfWordLength = 0;
		
		for (int i = 0; i < W; i++) {
			String tmp = st.nextToken();
			// 알고 있는 단어라면
			if (dict.contains(tmp)) {
				int idx = brain.indexOf(tmp);
				// 새로 외운 것으로 간주하기 위해 링크드리스트 맨 뒤로 보낸다.
				brain.remove(idx);
				brain.addLast(tmp);
				answer += 1;
			}
			// 모르는 단어라면
			else {
				// 뇌 용량이 충분하다.
				if (brain.size() < N) {
					// set에 현재 단어 추가
					dict.add(tmp);
					// 링크드리스트에 현재 단어 추가
					brain.addLast(tmp);
					sumOfWordLength += tmp.length();
				}
				// 뇌 용량이 부족하다.
				else {
					int avg = sumOfWordLength / N;
					for(String s: brain) {
						// 길이가 단어들의 평균 길이보다 길지 않은
						if (avg >= s.length()) {
							// 가장 오래된 단어(s)를 잊어버린다.
							// 링크드리스트에서 해당 단어 제거
							brain.remove(brain.indexOf(s));
							// set에 해당 단어 제거
							dict.remove(s);
							// sumOfWordLength에서 제거된 단어 길이 빼주기
							sumOfWordLength -= s.length();
							break;
						}
					}
					// 뇌 용량 비웠으니 새 단어로 채워주기
					// 링크드리스트에 단어 추가
					brain.addLast(tmp);
					// set에 단어 추가
					dict.add(tmp);
					// sumOfWordLength에서 추가된 단어 길이 더해주기
					sumOfWordLength += tmp.length();
				}
				answer += 3;
			}
		}
		
		bw.write(answer.toString());

		bw.flush();
		br.close();
		bw.close();
	}
}
