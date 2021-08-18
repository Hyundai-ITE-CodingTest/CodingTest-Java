package ex02;

import java.util.*;

public class Problem4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		int time = 0;
		
		List<String> words = new LinkedList<String>();
		List<String> memo = new LinkedList<String>();
		
		for(int i=0; i<W; i++) {
			words.add(sc.next());
		}
		
		for(int i=0; i<W; i++) {
			if(memo.contains(words.get(i))) {//단어를 암기하고 있으면
				time += 1;
				memo.remove(words.get(i)); //답한 단어를 최신화
				memo.add(words.get(i));
			}else {
				time += 3;
				
				if(memo.size() < N) {//머릿속에 더 들어갈 수 있으면
					memo.add(words.get(i));
				}
				else {
					double avg = 0;
					for(int j=0; j<memo.size(); j++) {
						avg += memo.get(j).length();
					}
					avg /= N; //평균 단어길이 계산
					int j=0;
					while(j<memo.size()) {
						if (memo.get(j).length() < avg) {
							memo.remove(j);
							memo.add(words.get(i));
							break;
						}
						j++;
					}
				}
			}
		}
		
		System.out.println(time);
	}
}
