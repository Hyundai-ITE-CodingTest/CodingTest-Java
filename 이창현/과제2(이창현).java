import java.util.*;

public class Homework2 {
	public static void main(String[] args) {
		System.out.print("입력.>> ");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String[] arr = s.split(","); // ,
		int min = Integer.MAX_VALUE; // 최솟값 구하기
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			int re = Integer.parseInt(arr[i]); 

			if (re % 2 == 1) {
				sum += re;
				min = Math.min(re, min); // 두 인자 값 중 작은 값을 리턴
			}
		}

		if (sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}

	}
}
