import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int[] input = new int[w];
		int ans = 0;
		int left, right;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<w; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		/*
		 * 양 옆에 더 큰 건물들이 있으면 빗물이 담긴다.
		 * 현재 내가 있는 위치보다 왼쪽에서 제일 큰 값(빌딩높이)을 구한다.
		 * 오른쪽에서도 구한다.
		 * 둘 중에 더 작은 값을 구한다.
		 * 그 값에서 현재 빌딩 높이의 값을 빼서 더해준다.
		 * */
     
		for(int i=1; i<w-1; i++) {
			left = 0;
			right = 0;
			for(int j=0; j<i; j++)	left = Math.max(input[j], left);
			for(int j=i+1; j<w; j++) right = Math.max(input[j], right);
			int min = Math.min(left, right);
			if(input[i]<left && input[i]<right) {
				ans += min-input[i];
			}
		}
		System.out.println(ans);
	
	}
}
