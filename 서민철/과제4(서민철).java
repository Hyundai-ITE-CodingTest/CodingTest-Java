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

		String pw = new String(br.readLine());

		for (int i = 0; i < pw.length(); i++) {
			int c = pw.charAt(i) + 4;
			bw.write(c);
		}

		bw.flush();
		bw.close();
		br.close();
	}

}