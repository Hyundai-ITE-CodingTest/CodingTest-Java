import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		System.out.println(hansu(n));
	}
	
	public static int hansu(int n) {
		int answer = 0;
		if(n < 100) {
			answer = n;
			return answer;
		}
		
		answer = 99;
		if(n == 1000) {
			answer--;
		}
		// n 100 이상부터
		for (int i = 100; i <= n; i++) {
			int[] digits = new int[3];
			int temp = i;
			for(int j = 0; j < 3; j++) {
				digits[j] = temp % 10;
				temp /= 10;
			}
			if (digits[2] - digits[1] == digits[1] - digits[0]) {
				answer++;
			}
		}
		return answer;
	}
}
