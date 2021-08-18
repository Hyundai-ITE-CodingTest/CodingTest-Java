package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quiz_02 {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("시작수 : ");
		int startNum = Integer.parseInt(bf.readLine());
		System.out.print("끝수 : ");
		int endNum = Integer.parseInt(bf.readLine());
		System.out.print("배수 : ");
		int multiple = Integer.parseInt(bf.readLine());
		
		long sum = 0;
		if (startNum > endNum) {
			System.out.println("-1");
		}else {
			endNum -= (endNum % multiple);
			while (endNum >= startNum) {
				sum += endNum;
				endNum -= multiple;
			}
			System.out.println(sum);
		}
		
	}
}
