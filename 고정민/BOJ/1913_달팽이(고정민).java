import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int start = 1;
	static int x, y, N;
	static int[][] table;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		int search = Integer.parseInt(br.readLine());
		
		table = new int[N][N];
		makeTable();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(table[i][j]+" ");
				if(search == table[i][j])
					sb2.append((i+1)+" "+(j+1));
			}
			if(i!=N-1) sb.append("\n");
		}
		System.out.println(sb.toString());
		System.out.println(sb2.toString());
		
	}
	public static int[][] makeTable() {
		x = N/2;
		y = N/2;
		
		//시작점
		table[y][x] = start;
		int count = 1;
		
		while(true) {
			//위
			for(int i=0; i<count; i++) {
				table[--y][x] = ++start;
				if(y== 0 && x== 0) return table;
			}
			//오른쪽
			for(int i=0; i<count; i++) table[y][++x] = ++start;
			
			count++;
			
			//아래쪽
			for(int i=0; i<count; i++) table[++y][x] = ++start;
			//왼쪽
			for(int i=0; i<count; i++) table[y][--x] = ++start;
			
			count++;
		}
		
	}
}
