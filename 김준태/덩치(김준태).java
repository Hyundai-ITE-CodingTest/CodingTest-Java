import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		int num = Integer.parseInt(bf.readLine());
		int[][] stat = new int[num][2];
		
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(bf.readLine());
			stat[i][0] = Integer.parseInt(st.nextToken());
			stat[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < num; i++) {
			int rank = 1;
			for (int j = 0; j < num; j++) {
				if(i != j) {
					if(stat[i][0] < stat[j][0] && stat[i][1] < stat[j][1]) {
						rank++;
					}
				}
			}
			System.out.print(rank + " ");
		}		
	}
}
