package kosa.ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class day0818ex3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	스택,힙 메모리 공간 절약
	static int N, sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
//		사과의 점수를 저장할 배열 선언
		int[] arr = new int[N];
		//공백으로 구분된 내용을 잘라준다.
		StringTokenizer st = new StringTokenizer(br.readLine());
		//사과의 점수 배열에 저장
		for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		String row1 = br.readLine();
		String row2 = br.readLine();
		
		// O 인 원통이 있는 곳만 저장
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < row1.length(); i++) {
			if(row1.charAt(i)=='O') {
				list.add(i);
			}
		}
		//O인 원통인 곳중 2번째 줄도 O면 sum 에 더해줌 전체를 확인하는 것보다 효율적
		for (Integer i : list) {
			if(row2.charAt(i)=='O') {
				sum+=arr[i];
			}
		}
		System.out.println("총 점수\n");
		System.out.println(sum);
	}

}
