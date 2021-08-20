package Projects8_18;

import java.util.Scanner;
import java.util.*;

public class Pro4 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
			List<String> brain = new LinkedList<String>(); // 외울 내용을 저장할 뇌 용량
			int N = input.nextInt(); //암기할 수 있는 수
			int W = input.nextInt(); //단어의 수
			String [] Word = new String[W];
			int time = 0;//걸리는 시간
			double brainLengthSum = 0;
			double brainLengthAvg = 0; // 암기하고 있는 단어들의 평균 길이
			//영어단어 리스트 저장
			
			for(int i = 0; i < Word.length; i++) {
				Word[i] = input.next();
				//System.out.print(Word[i] +" "); 정상적으로 들어가는 것 확인
			}
			
			for(int i = 0; i < Word.length; i++) {
				
				
				if(brain.size()< N ) { //앞에 단어는 무조건 넣는다.
					brain.add(Word[i]);
					time += 3;
					//System.out.println(brain.size());
					//System.out.println(brain.get(i));
					brainLengthSum += brain.get(i).length();
				}
				else {
					
						if(brain.contains(Word[i])) { //단어가 기존에 외우고 있었던 단어라면
							
							brain.remove(brain.indexOf(Word[i]));
							brain.add(Word[i]);
							time++;
							
							
						}
						else { //새로운 단어가 추가되었다면
							for(String str2 : brain) {
								if((double)str2.length()>= brainLengthAvg) {
									continue;
								}
								else {
									brainLengthSum -= str2.length();
									brain.remove(str2);
									brain.add(Word[i]);
									time += 3;
									brainLengthSum += Word[i].length();
									break;
								}
							}
						}
					
				}
			 brainLengthAvg = brainLengthSum / N;
			}
			
			System.out.println(time);
			for(String i : brain) {
				System.out.print(i + " ");
			}
			
			
			
	}

}
