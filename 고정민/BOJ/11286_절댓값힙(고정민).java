import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
	    int n = Integer.parseInt(br.readLine());

	    PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) == Math.abs(o2)) { //절댓값이 같으면
					return Integer.compare(o1, o2); //들어온 값끼리 비교(오름차순)
				}
				return Integer.compare(Math.abs(o1), Math.abs(o2)); //절댓값끼리 비교(오름차순) 
			}
		});
	    
	    for(int i = 0 ; i< n; i++) {
	    	int num = Integer.parseInt(br.readLine());
	    	
	    	if(num == 0) { //입력한 숫자가 0인데
	    		if(q.size()==0) //큐 사이즈가 0이면
	    			sb.append("0\n"); //0출력
	    		else
	    			sb.append(q.poll() + "\n"); //큐사이즈가 0이 아니면 큐에서 뺀 값 출력
	    	}else //0이 아닐 경우엔 큐에 추가 
	    		q.offer(num);
	    }
	    
	    System.out.print(sb.toString());
	}
}
