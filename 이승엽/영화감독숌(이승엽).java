import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<String> arr = new ArrayList<String>();
		int num = 666;
		while(arr.size() != 10001) {
			String temp = String.valueOf(num);
			if(temp.contains("666")) {
				arr.add(temp);
			}
			num++;
		}
		System.out.println(arr.get(n-1));

	}


}
