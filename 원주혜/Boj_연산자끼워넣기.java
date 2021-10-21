import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static int[] operands;
	static int[] operators;
	static int MAX = -1000000001;
	static int MIN = 1000000001;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		operands = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		operators = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
    selectOpt(1, operands[0]);
		System.out.print(MAX +"\n" + MIN);
		
	}

	public static void selectOpt(int pickedNum, int leftresult) {
		if(pickedNum == N) {
			if(leftresult > MAX) {
				MAX = leftresult;
			}
			if(leftresult < MIN) {
				MIN = leftresult;
			}
			//System.out.println("final result " + leftresult);
			return;
		}	
		
		//use operator (N-1)
		int leftresultOrg = leftresult;
		for(int j = 0; j < 4; j++) {
			if(operators[j] > 0) {
				operators[j] -= 1;
				if(j == 0) {
					leftresult += operands[pickedNum];
				}else if(j== 1) {
					leftresult -= operands[pickedNum];
				}else if(j==2) {
					leftresult *= operands[pickedNum];
				}else if(j==3) {	
					if(leftresult < 0) {
						leftresult = -((int) Math.floor(Math.abs(leftresult / operands[pickedNum])));
					}else {
						leftresult = (int) Math.floor(leftresult / operands[pickedNum]);
					}
				}
				//System.out.println("leftresult " + leftresult);
				selectOpt(pickedNum + 1, leftresult);
        
				operators[j] += 1;
				leftresult = leftresultOrg;
			}
		}
	}
}
