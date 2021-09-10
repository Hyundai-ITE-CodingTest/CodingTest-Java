import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		int[] array = new int[n];
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ; i < str.length; i++) {
			array[i] = Integer.parseInt(str[i]);
		}
		int[] sorted_array = array.clone(); //정렬할 배열
		Arrays.sort(sorted_array);
		
		int index = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<n; i++) {
			if(!map.containsKey(sorted_array[i])) {
				map.put(sorted_array[i], index++);
			}
		}
		
		for(int i = 0; i<array.length; i++) {
			sb.append(map.get(array[i])).append(' ');
		}
		System.out.print(sb.toString());
		
	}
}
