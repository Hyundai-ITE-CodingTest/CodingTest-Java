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

		StringTokenizer st = new StringTokenizer(br.readLine(), ",");

		Integer A = Integer.parseInt(st.nextToken());
		Integer B = Integer.parseInt(st.nextToken());
		Integer C = Integer.parseInt(st.nextToken());

		String mulVal = String.valueOf(A * B * C);
		System.out.println(mulVal);

		Integer[] arr = new Integer[10];

		for (int i = 0; i < 10; i++) {
			arr[i] = 0;
		}

		for (int i = 0; i < mulVal.length(); i++) {
			int idx = mulVal.charAt(i) - '0';
			arr[idx] += 1;
		}

		for (int i = 0; i < 10; i++) {
			bw.write(arr[i].toString() + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}