import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] coor = new int[n][2];
				
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		    coor[i][0] = Integer.parseInt(st.nextToken()); //x좌표 
		    coor[i][1] = Integer.parseInt(st.nextToken()); //y좌표
		}
		
		Arrays.sort(coor, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {//x좌표가 같으면 
					return o1[1] - o2[1]; //y좌표 오름차순
				}else	return o1[0]-o2[0]; //아니면 x좌표 오름차순
			}
		});
		
		for(int i =0; i<coor.length;i++) {
			System.out.println(coor[i][0] + " " + coor[i][1]);
		}
	}
}
