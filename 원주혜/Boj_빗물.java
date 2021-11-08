import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int H = Integer.parseInt(NM[0]);
		int W = Integer.parseInt(NM[1]);
		int[] input = Arrays.asList((br.readLine()).split(" ")).stream().mapToInt(Integer::parseInt).toArray();

		int answer = 0;

		// 왼쪽부터 돌기
		int leftsum = 0;
		int leftstart = 0;
		for (int i = 1; i < W; i++) {
			if (input[leftstart] <= input[i]) {
				answer += leftsum;
				leftstart = i;
				leftsum = 0;
				continue;
			}
			leftsum += input[leftstart] - input[i];
		}

		// 오른쪽 돌기
		int rightsum = 0;
		int rightstart = W - 1;
		for (int i = W - 2; i > 0; i--) {
			if (input[rightstart] < input[i]) {
				answer += rightsum;
				rightstart = i;
				rightsum = 0;
				continue;
			}
			rightsum += input[rightstart] - input[i];
		}
		System.out.print(answer);
	}

}
