package codingtest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AppleScore {

	public static void main(String[] args) {
		
		int num = 10;
		String scoreInput = "90 100 45 30 72 1 22 100 9 15";
		String str = "XXOOXXXXOO";
		String str2 = "XOOOOOXOOO";
		
		List<String> scoreStr = Arrays.asList(scoreInput.split(" "));
		List<Integer> scores = scoreStr.stream().map(v -> Integer.parseInt(v)).collect(Collectors.toList());
		int answer = 0;
		
		for(int i=0; i < num; i++) {
			if(str.charAt(i) == 'O' && str2.charAt(i) == 'O') {
				answer += scores.get(i);
			}
		}
		System.out.println(answer);
	
	}

}
