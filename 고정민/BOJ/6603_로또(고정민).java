import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Lotto {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] str = br.readLine().split(" ");
			int n = Integer.parseInt(str[0]);
			if(n==0)	break;
			
			int[] array = new int[n];
			int[] answer = new int[6];
			for(int i=0; i< str.length-1; i++) {
				array[i] = Integer.parseInt(str[i+1]);
			}
			
			combination(0, array, answer, 0);
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	public static void combination(int current, int[] arr, int[] ans, int start) throws IOException {
		if(current == 6) {
			for(int a: ans) {
				bw.write(a+ " ");
			}
			bw.write("\n");
			return;
		}else {
			for(int i = start; i<arr.length;i++) {
				ans[current] = arr[i];
				combination(current+1, arr, ans, i+1);
			}
		}
	}
}
