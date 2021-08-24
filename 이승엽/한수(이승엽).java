import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n < 100) {
			System.out.println(n);
		}else {
			int sum = 99;
			for(int i = 100; i <= n; i++) {
				String str = String.valueOf(i);
				if(str.charAt(0)-str.charAt(1)==str.charAt(1)-str.charAt(2)) {
					sum++;
				}
			}
			System.out.println(sum);
		}
	}
}
