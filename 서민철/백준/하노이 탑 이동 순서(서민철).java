import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList; 
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		int K = (int) Math.pow(2, N) - 1;
		
		bw.write(String.valueOf(K));
		bw.newLine();

		hanoi(1, 2, 3, N);

		bw.flush();
		bw.close();
		br.close();
	}

	public static void hanoi(int start, int mid, int end, int n) throws IOException {
		if (n == 1) {
			bw.write(String.valueOf(start) + " " + String.valueOf(end));
			bw.newLine();
			return;
		}

		hanoi(start, end, mid, n - 1);
		hanoi(start, mid, end, 1);
		hanoi(mid, start, end, n - 1);
	}
}