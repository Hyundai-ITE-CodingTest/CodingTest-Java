import java.util.Scanner;

public class no03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] li = str.split(",");
		long temp = 1L;
		
		for(int i  = 0; i < 3; i++) {
			temp *= Integer.parseInt(li[i]);
		}

		str = String.valueOf(temp);
		int[] arr = new int[10];
		
		for(int i = 0; i < str.length(); i++) {
			int num = str.charAt(i)-'0';
			arr[num]++;
		}
		
		for(int i = 0;i < 10; i++) {
			System.out.println(arr[i]);
		}
		
	}

}
