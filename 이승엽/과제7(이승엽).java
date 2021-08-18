import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no03 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] score = new int[n];
		int[] t = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			score[i] = Integer.parseInt(st.nextToken());
		}

		for (int j = 0; j < 2; j++) {
			String str = br.readLine();
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == 'X') {
					t[i]++;
				}
			}
		}
		
		int sum = 0;
		for(int i = 0; i < n; i++) {
			if(t[i] == 0) {
				sum += score[i];
			}
		}
		
		System.out.println(sum);

	}

}
