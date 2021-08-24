import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}

		while (queue.size() > 1) {
			queue.remove();
			int goBottom = queue.remove();
			queue.add(goBottom);
		}

		System.out.println(queue.remove());
	}
}