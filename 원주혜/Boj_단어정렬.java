import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		HashSet<String> set = new HashSet<String>();

		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			set.add(word);
		}
		
		List<String> setlist = new ArrayList<>(set);
		Collections.sort(setlist, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int firstSort = o1.length() - o2.length();
				if(firstSort == 0) {
					return o1.compareTo(o2);
				}
				return firstSort;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for (String string : setlist) {
			sb.append(string + "\n");	
		}
		System.out.println(sb.toString().trim());

	}

}
