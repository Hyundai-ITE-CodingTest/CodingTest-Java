import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
        // 이분탐색으로 풀었는데 그냥 HashSet으로 풀면 더 쉬울 듯?
        // 이분탐색을 기본적으로 제공하는 게 있다... 
        // Arrays.binarySearch(배열, 찾는 값)[사용 전 정렬 필수]
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(bf.readLine());
		int[] arrA = new int[n];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(bf.readLine());
		int[] numbers = new int[m];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < m; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arrA); // 이분탐색은 정렬 필수

		for (int i = 0; i < m; i++) {
			if (binarySearch(arrA, numbers[i], 0, n - 1))
				sb.append(1).append('\n');
			else
				sb.append(0).append('\n');
		}

		System.out.println(sb);
	}

	public static boolean binarySearch(int[] arr, int target, int low, int high) {
		if (low > high)
			return false;

		int mid = (low + high) / 2;

		if (arr[mid] == target)
			return true;
		else if (arr[mid] < target)
			return binarySearch(arr, target, mid + 1, high);
		else
			return binarySearch(arr, target, low, mid - 1);

	}

}

// 다른 사람 코드
// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.util.HashSet;
// import java.util.StringTokenizer;

// public class Main {
//     public static void main(String[] args)throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int n = Integer.parseInt(br.readLine());
//         HashSet<String> set = new HashSet<>();
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         for (int i = 0; i < n; i++) {
//             set.add(st.nextToken());
//         }
//         n = Integer.parseInt(br.readLine());
//         st = new StringTokenizer(br.readLine());
//         StringBuilder sb = new StringBuilder();
//         for (int i = 0; i < n; i++) {
//             if (set.contains(st.nextToken())) {
//                 sb.append("1\n");
//             }else{
//                 sb.append("0\n");
//             }
//         }
//         System.out.println(sb.toString());
//     }
// }
