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
		Integer minVal = -1;
		Integer sumVal = 0;

		while (st.hasMoreTokens()) {
			int tmp = Integer.parseInt(st.nextToken());

			if (tmp % 2 == 1) {
				sumVal += tmp;
				if (minVal == -1) {
					minVal = tmp;
				} else {
					minVal = Math.min(minVal, tmp);
				}
			}
		}

		bw.write(sumVal.toString() + "\n");
		bw.write(minVal.toString());

		bw.flush();
		bw.close();
		br.close();
	}

}
