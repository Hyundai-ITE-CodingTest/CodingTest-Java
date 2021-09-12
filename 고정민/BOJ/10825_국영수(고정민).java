import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
	    String[][] student = new String[n][4];
		
		for(int i=0; i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			student[i][0] = st.nextToken(); //이름
			student[i][1] = st.nextToken(); //국어 
			student[i][2] = st.nextToken(); //영어 
			student[i][3] = st.nextToken(); //수학 		
		}
		
		Arrays.sort(student, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				if(Integer.parseInt(o1[1]) == Integer.parseInt(o2[1])) {
					if(Integer.parseInt(o1[2]) == Integer.parseInt(o2[2])) {
						if(Integer.parseInt(o1[3]) == Integer.parseInt(o2[3])) {
							return o1[0].compareTo(o2[0]);
						}
						return Integer.compare(Integer.parseInt(o2[3]), Integer.parseInt(o1[3]));
					}
					return Integer.compare(Integer.parseInt(o1[2]), Integer.parseInt(o2[2]));
				}
				return Integer.compare(Integer.parseInt(o2[1]), Integer.parseInt(o1[1]));
			}
		});
		
		for(int i = 0; i<n;i++) {
	    	System.out.println(student[i][0]);
	    }
	}
	
}
