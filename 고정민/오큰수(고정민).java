import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());    
    int[] a = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i<n; i++){
      a[i] = Integer.parseInt(st.nextToken());
    }
    Stack<Integer> stack = new Stack<>();

    for(int i = 0; i<n; i++){
      while(!stack.isEmpty() && a[i] > a[stack.peek()]){
          a[stack.pop()] = a[i];
      }
      stack.push(i);
    }
    while(!stack.isEmpty()){
      a[stack.pop()] = -1;
    }
    
    StringBuilder sb = new StringBuilder();
    for(int ai: a){
      sb.append(ai).append(' ');
    }
      
    System.out.println(sb);
  }
}
