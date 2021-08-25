import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Node {
	int idxValue;
	int idx;

	Node(int idxValue, int idx) {
		this.idxValue = idxValue;
		this.idx = idx;
	}

}

public class Main {

	public static void main(String[] args) throws IOException {
		// 영상보고 풀었습니다! 대박..
		// https://www.youtube.com/watch?v=XwG-QcBQ9-I
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(bf.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Node> stack = new Stack<>();

		// 스택에 (숫자,인덱스)를 넣고, 마지막 넣은 값과 다음 값을 넣기 전에 비교해서 다음 값이 크면.
		for (int i = 0; i < n; i++) {
			while (stack.size() > 0 && stack.peek().idxValue < arr[i]) {
				Node topNode = stack.pop();
				arr[topNode.idx] = arr[i];
			}
			stack.push(new Node(arr[i], i));
		}

		// 2번 째 예제 처럼 9가 남음, -1인 것들
		while (!stack.isEmpty()) {
			Node topNode = stack.pop();
			arr[topNode.idx] = -1;
		}

		// 마지막은 항상 -1
		arr[n - 1] = -1;

		for (int val : arr)
			sb.append(val).append(" ");

		System.out.println(sb);
	}

// 시간 초과 뜨는 코드 O(N^2) 잘못된 접근 - 데이터 수 1,000,000
//	for (int i = 0; i < n; i++) {
//		boolean isExist = false;
//		int idx = 0;
//		for (int j = i + 1; j < n; j++) {
//			if (arr[i] < arr[j]) {
//				isExist = true;
//				idx = j;
//				break;
//			}
//		}
//		if (isExist)
//			answer[i] = arr[idx];
//		else
//			answer[i] = -1;
//	}
//
//	for (int val : answer)
//		sb.append(val).append(" ");
//
//	System.out.println(sb);
}