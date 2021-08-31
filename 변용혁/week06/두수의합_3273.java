package week06;

import java.io.*;
import java.util.*;

public class 두수의합_3273 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int x = Integer.parseInt(br.readLine());
		int left = 0;
		int right = n - 1;
		int answer = 0;
		
		while(left < right) {//쌍을 찾는것 이므로 등호 X
			int temp = arr[left] + arr[right];
			if(temp > x) { // 더한숫자가 크면 작은숫자로 교체
				right -= 1;
			}else if(temp < x){// 더한숫자가 작으면 큰숫자로 교체
				left += 1;
			}else {
				answer += 1;
				//n개의 서로 다른 양의 정수 - 중복 없으므로
				right -= 1;
				left += 1;
			}
		}
		
		System.out.println(answer);
	}
}
