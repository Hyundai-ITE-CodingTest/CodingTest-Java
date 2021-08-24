import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		int count = 0;
		int num = 665;
		
		while(n != count) {
			num++;
			if(Integer.toString(num).contains("666")) {
				count++;
			}
		}
		System.out.println(num);
	}
}
