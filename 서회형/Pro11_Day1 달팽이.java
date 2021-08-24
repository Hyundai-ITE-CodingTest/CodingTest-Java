package code8_21;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class pro1_test {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Integer N = Integer.parseInt(br.readLine());
		Integer Search = Integer.parseInt(br.readLine());
		
		int [][] numStore = new int[N][N]; // 달팽이식으로 저장할 배열
		int inputCount = 1;// 1을 가운데 넣어줬기 때문에 1부터 시작
		int x = (N-1)/2; //x좌표
		int y = (N-1)/2; //y좌표
		int sw = 1; //sw가 1일땐 - sw가 0일땐 +
		int limitCount = N;
		int searchX = 0; //search의 x좌표
		int searchY = 0; //search의 y좌표
		int t1 = 1;
		int t2 = 1;
		int Xmove = 1;
		int XmoveCount = 1;
		int Ymove = 0;
		int YmoveCount = 1;
		
		int k = 1;// 처음 들어갈값
		numStore[numStore.length/2][numStore.length/2] = 1;
		
			while(inputCount < N * N-1) {
				if(sw == 1 && Xmove == 1) {
					for(int i = 0; i  < XmoveCount; i++) {
						if(XmoveCount == N && i == XmoveCount-1)
						{
							break;
						}
						numStore[--x][y] = ++k;
						inputCount++;
					}
					sw = 0;
					Xmove = 0;
					Ymove = 1;
					XmoveCount++;
				}
				else if(sw == 0 && Xmove == 1) {
					for(int i = 0; i < XmoveCount; i++) {	
						numStore[++x][y] = ++k;
						inputCount++;
					}
					sw = 1;
					Xmove = 0;
					Ymove = 1;
					XmoveCount++;
				}
				else if(sw == 1 && Ymove == 1) {
					for(int i = 0; i < YmoveCount; i++) {	
						numStore[x][--y] = ++k;
						inputCount++;
					}
					sw = 1;
					Ymove = 0;
					Xmove = 1;
					YmoveCount++;
				}
				else if(sw == 0 && Ymove == 1) {
					for(int i = 0; i < YmoveCount; i++) {
						numStore[x][++y] = ++k;
						inputCount++;
					}
					sw = 0;
					Ymove = 0;
					Xmove = 1;
					YmoveCount++;
				}
			}
	
		// 달팽이 배열 출력
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N ; j++) {
				if(numStore[i][j] == Search) {
					searchX = i+1;
					searchY = j+1;
				}
				bw.write(numStore[i][j]+ " ");  
			}
			bw.newLine();
		}
		
		//입력받은 숫자의 좌표 출력
		bw.write(searchX + " " + searchY);
		
	
	    bw.flush();
		bw.close();
		br.close();
    }

}
