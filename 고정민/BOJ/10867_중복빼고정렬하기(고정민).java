import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Set<Integer> result = new HashSet<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			result.add(Integer.parseInt(st.nextToken()));
		}
		
		List<Integer> array = new ArrayList<>(result);
		Collections.sort(array);
		
		for(Integer arrs: array) {
			System.out.print(arrs + " ");
		}

	}
}
