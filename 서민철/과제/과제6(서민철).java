import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int x = Integer.parseInt(new String(br.readLine()));
		int y = Integer.parseInt(new String(br.readLine()));
		int c = Integer.parseInt(new String(br.readLine()));

		Integer sum = 0;

		for (int i = x; i <= y; i++) {
			if (i % c == 0) {
				sum += i;
			}
		}

		bw.write(sum.toString());

		bw.flush();
		br.close();
		bw.close();
	}
}
