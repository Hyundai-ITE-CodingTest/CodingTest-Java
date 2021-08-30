
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer n = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(br.readLine());
		StringTokenizer m = new StringTokenizer(br.readLine(), " ");
		int [] nArr = new int[n.countTokens()];
		int i = 0;
		while(n.hasMoreTokens()) {
			
			nArr[i] = Integer.parseInt(n.nextToken());
			i++;
		}
		Arrays.sort(nArr);
		// 범위를 처음에 N으로 설정해서 같은 값을 입력했을 경우 하나의 값만 출력하는 경우 발생 N과 M의개수가 다를 수 있다는 것을 인지할 것
		for(int j = 0; j < M;j++) {
			
			if(Search(nArr, Integer.parseInt(m.nextToken())) == -1){
				bw.write("0");
				
			}
			else {
				bw.write("1");
			}
			if(m.hasMoreTokens()) {
			bw.write("\n");
			}
			
		}
		bw.flush();
		bw.close();
		br.close();
		
		
		
	}
	
	static int Search(int a[], int SearchKey) {
		int low, high, mid;
		
		low =0;
		high = a.length-1;
		
		
		while(low <= high) {
			mid = (low + high) / 2;
			
			if(SearchKey == a[mid]) return mid;
			else if(SearchKey > a[mid]) low = mid + 1;
			else if(SearchKey < a[mid]) high = mid - 1;
		}
		return -1;
	}

}
