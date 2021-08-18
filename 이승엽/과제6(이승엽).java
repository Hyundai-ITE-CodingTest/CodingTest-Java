import java.io.BufferedReader;
import java.io.InputStreamReader;

public class no02 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("시작수: ");
		int start = Integer.parseInt(br.readLine());
		System.out.print("끝수: ");
		int end = Integer.parseInt(br.readLine());
		System.out.print("배수: ");
		int num = Integer.parseInt(br.readLine());
		
		int sum = 0;
		for(int i = start; i <= end; i++) { // 시작 값과 종료 값 포함해서 계산
			if(i % num == 0) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

}
