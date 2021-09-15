import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeMap;

public class Main {
	static TreeMap<Integer, LinkedList<Integer>> heap = new TreeMap<Integer, LinkedList<Integer>>();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			int curInput = Integer.parseInt(br.readLine());
			// remove
			if (curInput == 0) {
				int result = remove();
				sb.append(result).append("\n");
				continue;
			}
			// add
			add(curInput);
		}
		System.out.println(sb.toString().trim());
	}

	public static void add(int element) {

		if (heap.get(Math.abs(element)) == null) {
			LinkedList<Integer> list = new LinkedList<Integer>();
			list.add(element);
			heap.put(Math.abs(element), list);
		} else {
			LinkedList<Integer> list = heap.get(Math.abs(element));
			list.add(element);
			Collections.sort(list);
			heap.put(Math.abs(element), list);
		}
	}

	public static int remove() {
		if (heap.isEmpty()) {
			return 0;
		}
		int rootKey = heap.firstKey();
		LinkedList<Integer> rootValue = heap.pollFirstEntry().getValue();

		int first = rootValue.poll();
		if (rootValue.isEmpty()) {
			return first;
		}

		// 업데이트
		heap.put(rootKey, rootValue);

		return first;
	}
}
