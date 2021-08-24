package kosa.ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class day0818ex2 {
	//입력한 데이터를 버퍼에 모아뒀다가 사용
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int sum;
	
	public static void main(String[] args) throws IOException {
		// 문자열 중 사용하는 부분을 솎아내기 위한 StringTokenizer
		StringTokenizer st1= null;
		
		st1 = new StringTokenizer(br.readLine());
		st1.nextToken();
		int start = Integer.parseInt(st1.nextToken());
		st1 = new StringTokenizer(br.readLine());
		st1.nextToken();
		int end = Integer.parseInt(st1.nextToken());
		st1 = new StringTokenizer(br.readLine());
		st1.nextToken();
		int num = Integer.parseInt(st1.nextToken());
		
		//start 에서 end 까지 1씩 값이 증가하는 반복문 실행
		for (int i = start; i <= end; i++) {
			//특정 수로 나누어서 나머지가 0이면 그 수의 배수
			if(i%num==0) {
				sum += i;
			}
		}
		System.out.println(sum);
		
	}

}
