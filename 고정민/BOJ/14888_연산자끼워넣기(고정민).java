import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14888 {
	static int[] operators = new int[4];
	static int[] array;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		array = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			operators[i] = Integer.parseInt(st.nextToken());
		}
		
		//배열의 첫 번째 원소부터 시작, 연산을 하기 위한 다음(두 번째) 인덱스
		dfs(array[0], 1);
		
		System.out.println(max);
		System.out.println(min);
	}
	public static void dfs(int num, int index) {
		//종료조건 : 인덱스가 수열 끝에 왔을 때
		if(index == n) {
			max = Math.max(num, max);
			min = Math.min(num, min);
			return;
		}
		for(int i=0; i<4; i++) {
			if(operators[i] > 0) {
				operators[i]--;
				
				switch(i) {
				case 0:
					dfs(num+array[index], index+1);
					break;
				case 1:
					dfs(num-array[index], index+1);
					break;
				case 2:
					dfs(num*array[index], index+1);
					break;
				case 3:
					dfs(num/array[index], index+1);
					break;
				}
				operators[i]++;
			}
		}
	}
}
