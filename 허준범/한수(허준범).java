import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int hansu = 0;
		for (int i = 1; i <= n; i++) {
			if (i <= 99)
				hansu++;
			else { // 입력이 1000이하라고 함, 100 ~ 1000
				String[] hanString = String.valueOf(i).split("");
				int one = Integer.parseInt(hanString[0]);
				int two = Integer.parseInt(hanString[1]);
				int three = Integer.parseInt(hanString[2]);
				if ((one - two) == (two - three))
					hansu++;
			}
		}

		System.out.println(hansu);
	}

}
