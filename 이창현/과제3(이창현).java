import java.util.*;

public class Homework3 {
	public static void main(String[] args) {
		System.out.print("입력.>> ");
		Scanner sc = new Scanner(System.in);
		 
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int sum = A * B * C; // A*B*C 곱해서 저장
		
		int arr[] = new int[10]; // 출력 값 10줄
		
		while (sum > 0) { // 일의자리부터 검사.
			arr[sum % 10]++;
			sum /= 10; // 10으로 나눠 몫만 저장
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
