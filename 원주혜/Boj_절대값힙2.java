import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		PriorityQueue<IntegerX> xs = new PriorityQueue<IntegerX>();
		
		for (int i = 0; i < N; i++) {
			int curInput = Integer.parseInt(br.readLine());
			if (curInput == 0) {
				IntegerX result = xs.poll();
				if(result != null) {
					sb.append(result.X).append("\n");
				}else {
					sb.append(0).append("\n");
				}
				
				continue;
			}
			xs.add(new IntegerX(curInput));
		}
		System.out.println(sb.toString().trim());
	}
}


class IntegerX implements Comparable<IntegerX> {
    int X;
    int absX;

    public IntegerX(int X) {
        this.X = X;
        this.absX = Math.abs(X);
    }

    @Override
    public int compareTo(IntegerX target) {
    	
    	int first = this.absX - target.absX;
    	if(first == 0) {
    		return this.X - target.X;
    	}
        return first;
    }
}
