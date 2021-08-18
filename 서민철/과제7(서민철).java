import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(new String(br.readLine()));

		String[][] apple = new String[N][2];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		String[] obsStr = new String[2];
		obsStr[0] = br.readLine();
		obsStr[1] = br.readLine();

		Integer sum = 0;

		for (int i = 0; i < N; i++) {
			int score = Integer.parseInt(st.nextToken());
			
			if (obsStr[0].charAt(i) == 'X' || obsStr[1].charAt(i) == 'X') {
				continue;
			}
			
			sum += score;
		}
		
		bw.write(sum.toString());

		bw.flush();
		br.close();
		bw.close();
	}
}
