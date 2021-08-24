package kosa.ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class day0818ex4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, W, sum, avg;
	public static void main(String[] args) throws IOException {
		//공백으로 구분된 값을 구분하기 위해 사용
		StringTokenizer st = null;
		st=new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		//마지막 요소를 빼고 다시 마지막에 넣을 일이 있어 deque로 선언
		Deque<String> dq= new ArrayDeque();
		
		for (int i = 0; i < W; i++) {
			//입력받은 단어와 그 단어의 글자 수를 변수에 담기
			String word = st.nextToken();
			int word_len = word.length();
			
			// 단어가 있고 없는 case 로 나누기
			if(dq.contains(word)) {
				sum+=1;
				//deque의 처음으로 넣어줌
				dq.remove(word);
				dq.add(word);
				
			}else {
				sum +=3;
				
//				dq의 요소가 size에 따라 다르게 처리
				if(dq.size()<N) {
					dq.add(word);
					avg += word_len;
				}else if(dq.size()>=N) {
					String last = dq.poll();
					if(last.length()>avg/N) {
						String next_last =dq.poll();
						avg -= next_last.length();
						dq.addFirst(last);
						dq.add(word);
						avg += word_len;
					}else {
						avg -=last.length();
						dq.add(word);
						avg += word_len;
					}
				}
			}
		}
		System.out.println(sum);
	}

}


/*
3 5
hello hanwha hi ok hello 


 */
/*

단어를 들을 때마다 머릿속에 빈 자리가 있다면 바로 암기할 수 있다. 만약 머릿속에 N개의 단어를 암기하고 있어 빈자리가 없다면, 
가장 오래된 단어를 잊어버리고 새로운 단어를 암기한다.
가장 오래된 단어가 나가는 queue

만약 길이가 평균길이보다 길면 다시 넣어줘야함
양쪽으로 넣을 수 있는 deque

map 으로해서 map size 보고 
전체에 같은 값이 있는지도 봐야함


*/