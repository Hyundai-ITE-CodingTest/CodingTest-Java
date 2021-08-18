package codingtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AppleScore {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		String scoreInput = br.readLine();
		String str = br.readLine();
		String str2 =  br.readLine();
		
		// String[] => List
		List<String> scoreStr = Arrays.asList(scoreInput.split(" "));
		// 문자열을 Integer
		List<Integer> scores = scoreStr.stream()
				.map(v -> Integer.parseInt(v)) // [90, 100, 45,30, 72, 1, 22,,, ]
				.collect(Collectors.toList()); // [90, 100, 45,30, 72, 1, 22,,, ] => List
		
		int answer = 0;
		
		for(int i=0; i < num; i++) {
			if(str.charAt(i) == 'O' && str2.charAt(i) == 'O') {
				answer += scores.get(i);
			}
		}
		System.out.println(answer);
	
	}

}
