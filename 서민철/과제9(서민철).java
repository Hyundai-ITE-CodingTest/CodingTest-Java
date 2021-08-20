import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String map = br.readLine();

		// state가 true라면 값이 2배
		boolean state = false;

		int height = 0;
		Integer result = 0;

		for (int i = 0; i < map.length(); i++) {
			if (map.charAt(i) == '(') {
				height += 1;
				result += height;
				if (state) {
					result += height;
				}
			} else if (map.charAt(i) == ')') {
				result += height;
				if (state) {
					result += height;
				}
				height -= 1;
			} else {
				state = !state;
			}
		}

		bw.write(result.toString());

		bw.flush();
		bw.close();
		br.close();
	}
}