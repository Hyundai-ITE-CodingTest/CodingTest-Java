package codingtest;

import java.util.*;

public class 한수_1065_변용혁 {
	public static void main(String[] args) {
		int N = new Scanner(System.in).nextInt();
		int cnt = 0;

		for (int x = 1; x <= N; x++) {
			if (isHan(x))
				cnt++;
		}

		System.out.println(cnt);
	}

	public static boolean isHan(int x) {
		if (x < 100)
			return true;
		int temp1 = x % 10;
		x /= 10;
		int temp2 = x % 10;
		int temp = temp1 - temp2;

		while(x > 9) {
			temp1 = x % 10;
			x /= 10;
			temp2 = x % 10;
			if(temp1 - temp2 != temp)
				return false;
		}
		return true;
	}
}
