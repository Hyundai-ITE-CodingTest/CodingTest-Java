import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = (br.readLine()).split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		search(0, new String[M]);
		System.out.println(sb.toString().trim());
	}
	
	public static void search(int pickedNum, String[] picked) {
		if(pickedNum == M) {
			sb.append(String.join(" ", picked) +"\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			picked[pickedNum] = Integer.toString(i+1);
			search(pickedNum+1, picked);
		}
		
		return ;
	}

}
