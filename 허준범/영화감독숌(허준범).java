import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int title = 666;
		while (n > 0) {
			if (String.valueOf(title).contains("666")) {
				n--;
			}
			title++;
		}

		System.out.println(title - 1);
	}
}
