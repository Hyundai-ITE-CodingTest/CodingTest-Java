import java.util.Scanner;

public class no02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] strArr = str.split(",");
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for(int i = 0; i < strArr.length;i++) {
			int temp = Integer.parseInt(strArr[i]);
			if(temp%2 == 1) {
				sum += temp;
				min = Math.min(temp, min);
			}
		}
		if(sum == 0) {
			System.out.println(-1);
		}else {
			System.out.println(sum);
			System.out.println(min);
		}
			
	}

}
