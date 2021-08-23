package day0818;

import java.util.Scanner;

public class Multiple {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int start = sc.nextInt();
		int end = sc.nextInt();
		int multiple = sc.nextInt();
		
		int sum = 0;
		if(start<=end) {//end가 start이상일 때
			while(end>=start) {
				if(end%multiple == 0) {
					sum += end;
				}
				end--;
			}
		}else System.exit(0);
		
		System.out.println(sum);
	}
}
