import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line = bf.readLine();

		int cnt = 0;
		boolean doubleEvent = false;
		int result = 0;

		for (int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			if (ch == '(') {
				cnt++;
				if (doubleEvent)
					result += cnt * 2;
				else
					result += cnt;
			} else if (ch == ')') {
				if (doubleEvent)
					result += cnt * 2;
				else
					result += cnt;
				cnt--; // 내려갈 때는 더하고 낮추기
			} else if (ch == '#') {
				doubleEvent = !doubleEvent; // 반전
			}
		}

		System.out.println(result);
	}
}
