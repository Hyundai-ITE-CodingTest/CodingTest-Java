package Code8_28;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class 랜선자르기3 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		StringTokenizer str = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		long sum = 0;
		boolean done = true;
		int [] nArr = new int[N];
		// 처음 인덱스의 값
		int midIndex = 0;
		long max = 0;
		//배열에 입력값을 넣어줌
		for(int i = 0; i < N; i++){
			nArr[i]= Integer.parseInt(br.readLine());
			sum += nArr[i];
			max = Math.max(nArr[i], max);
		}
		//이분 탐색을 위해 정렬해줌
		Arrays.sort(nArr);
		
		
		Search(nArr, max, M);
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	static void Search(int [] a , long Max, long M) {
		long low = 1;
		long high = Max;
		long mid;
		
		while(low <= high ) {
			long count = 0;
			mid = (low + high) / 2;
			
			for(int i = 0; i < a.length; i++) {
				count+=a[i]/mid;
			}
			if(count >= M) {
				low = mid + 1;
			}
			
			else if(count < M) {
				high = mid - 1;
			}
			
		}
		System.out.println(high);
		
	}

}
