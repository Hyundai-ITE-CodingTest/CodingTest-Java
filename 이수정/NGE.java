import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class NGE {
    public static void main(String[] args) throws IOException {
        //1단계: 수열의 크기 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        //스택에 값 저장 => 마지막에 들어온게 먼저나간다
        int[] arr = new int[N];
        int[] result = new int[N];
        for(int i = 0; i< N; i++){
            arr[i] = Integer.parseInt(st.nextToken(" "));
            result[i] = -1;
        }
        Stack<Integer> stack = new Stack();
        //인덱스로 비교
        stack.push(0);
        for(int i = 1; i <N; i++) {//다음수가 무조건 큰값이 나올 경우
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                result[stack.pop()] = arr[i];
                }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            result[stack.pop()] = -1;
        }
      //출력값에 printf를 쓰니 시가 초과가 잡혔다.-------------------------------
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int j = 0; j< N; j++){
            bw.write(result[j]+" ");
        }
        bw.flush();
        bw.close();
    }
}
/*중첩 for문 => 시간복잡도 제곱 증가
stack.push(arr[0]); //3
        for(int i = 1; i< N; i++){//1,2,3
            if(stack.peek() < arr[i]){//3 > 5
                result[i-1] = arr[i];
            }else{
                for(int j = i+1; j <N; j++){
                    if(stack.peek() < arr[j]){
                        result[i-1] = arr[j];
                    }else{
                        result[i-1] = -1;
                    }
                }
            }
            stack.push(arr[i]);//5
        }
        result[N-1] = -1;
 */
