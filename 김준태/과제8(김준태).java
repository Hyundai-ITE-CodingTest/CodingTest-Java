package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Quiz_04 {
	public static void main(String[] args) throws IOException{
		// 입력 암기할 수 있는 수 N, 단어의수 W
		// 둘째 줄 영어단어 공백으로 구분
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		String[] words = bf.readLine().split(" ");
		int time = 0;
		int sum = 0;
		
		// 총 N개 단어의 뜻을 암기할 수 있음
		ArrayList<String> memo = new ArrayList();
		
		for (int i = 0; i < w; i++) {
			if (memo.contains(words[i])) {
				// 머릿속에 있는 단어라면 1초만에 대답
				time += 1;
				// 암기하고 있는 단어를 들으면 새로 외운것이 된다.(시점도 최신)
				int index = memo.indexOf(words[i]);
				memo.remove(index);
				memo.add(words[i]);
			}else {
				// 머릿속에 없는 단어라면 3초만에 대답
				time += 3;
				// 머릿속에 빈자리가 있다면 바로 암기할 수 있음
				if(memo.size() < n) {
					memo.add(words[i]);
					sum += words[i].length();
				}else {
					// 머릿속에 빈자리가 없다면 가장 오래된 단어 삭제
					// 하지만 잊어버려야 하는 단어가 외우고 있는 단어들의 평균 길이보다 길다면 
					// 그다음 오래된 단어를 잊어버린다.
					if (memo.get(0).length() > (sum/w)) {
						sum -= memo.get(1).length();
						memo.remove(1);
					}else {
						sum -= memo.get(0).length();
						memo.remove(0);
					}
				}
			}
		}
		System.out.print(time);
	}
}
