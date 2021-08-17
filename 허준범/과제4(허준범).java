package homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P4 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line = bf.readLine();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < line.length(); i++) {
			int ascii = line.charAt(i); // char -> int
			char ch = (char) ((ascii + 4) % 123); // int -> char
			sb.append(ch);
		}
		System.out.println(sb);
	}
}
