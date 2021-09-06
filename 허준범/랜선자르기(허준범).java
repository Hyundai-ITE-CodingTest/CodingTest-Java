import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		long[] arr = new long[k]; // 랜선 길이 long으로 해야됨
		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		Arrays.sort(arr);

		long result = 0;
		result = binarySearch(arr, n, k, 1, arr[k - 1]); // low는 0으로 하면 zero 에러남

		System.out.println(result);
	}

	public static long binarySearch(long[] arr, int target, int k, long low, long high) {
		if (low > high)
			return high;

		long mid = (low + high) / 2;
		int count = 0;

		for (int i = 0; i < k; i++) {
			count += arr[i] / mid; // 만들 수 있는 랜선의 개수
		}

		if (count < target)
			return binarySearch(arr, target, k, low, mid - 1);
		else { // count >= target
			return binarySearch(arr, target, k, mid + 1, high);
		}
	}
}