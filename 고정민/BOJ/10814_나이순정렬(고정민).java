package boj.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class AgeSort {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    int n = Integer.parseInt(br.readLine());
	    String[][] arr = new String[n][2];

	    for(int i=0; i<n; i++){
	      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	      arr[i][0] = st.nextToken(); //나이
	      arr[i][1] = st.nextToken(); //이름
	    }
	    
	    Arrays.sort(arr, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				return Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]));
			}
		});
	    
	    for(int i = 0; i<n;i++) {
	    	System.out.println(arr[i][0] + " " + arr[i][1]);
	    }
	    
	}
}
