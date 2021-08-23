import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = sc.nextInt();
		int k = sc.nextInt();
		int cnt = n * n;
		int x, y;
		x = -1;
		y = 0;
		int[][] arr = new int[n][n];
		int[] check = new int[2];
		
		arr[n/2][n/2] = 1;

		while (x != n / 2 && y != n / 2) {
			while(true) {
				x++;
				if(x < n && arr[x][y] == 0) {
					arr[x][y] = cnt--;
				}else {
					x--;
					break;
				}
			}
			
			while(true) {
				y++;
				if(y < n && arr[x][y] == 0) {
					arr[x][y] = cnt--;
				}else {
					y--;
					break;
				}
			}
			
			while(true) {
				x--;
				if(x >= 0 && arr[x][y] == 0) {
					arr[x][y] = cnt--;
				}else {
					x++;
					break;
				}
			}
			
			while(true) {
				y--;
				if(y >= 0 && arr[x][y] == 0) {
					arr[x][y] = cnt--;
				}else {
					y++;
					break;
				}
			}
			
			
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[i][j] == k) {
					check[0] = i+1;
					check[1] = j+1;
				}
				bw.append(arr[i][j] + " ");
			}
			bw.append("\n");
		}

		bw.append(check[0] + " " + check[1]);

		bw.flush();
		bw.close();
	}

}
