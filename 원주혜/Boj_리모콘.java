import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static boolean remoteCtrl[] = new boolean[10];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		if (M > 0) {
			int[] brokens = Arrays.asList((br.readLine()).split(" ")).stream().mapToInt(Integer::parseInt).toArray();
			for (int btn : brokens) {
				remoteCtrl[btn] = true;
			}
		}
		final int cur = 100;

		// 만들 수 있는 가장 가까운 수 찾기
		int smallest = makeTheNearest(N);
		int smallest2 = makeTheNearest2(N);
		//System.out.println("smallest " + smallest);
		//System.out.println("smallest2 " + smallest2);

		int min = Math.min(Math.abs(N - smallest) + Integer.toString(smallest).length(), Math.abs(N - cur));
		min = Math.min(Math.abs(N - smallest2) + Integer.toString(smallest2).length(), min);

		System.out.print(min);
	}

	public static int makeTheNearest(int N) {
		boolean sucFlag = false;

		while (N >= 0) {

			String str = Integer.toString(N);
			for (int i = 0; i < str.length(); i++) {
				if (remoteCtrl[str.charAt(i) - '0']) {
					sucFlag = false;
					break;
				}
				sucFlag = true;
			}

			if (sucFlag) {
				return N;
			}

			N = N - 1;
		}
		
		return 1000001;
	}

	public static int makeTheNearest2(int N) {
		boolean sucFlag = false;

		while (N < 1000001) {

			String str = Integer.toString(N);
			for (int i = 0; i < str.length(); i++) {
				if (remoteCtrl[str.charAt(i) - '0']) {
					sucFlag = false;
					break;
				}
				sucFlag = true;
			}

			if (sucFlag) {
				return N;
			}

			N = N + 1;
		}
		
		return 1000001;
	}

}
