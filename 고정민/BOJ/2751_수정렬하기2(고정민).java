import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

//시간초과주의하자,,
class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    ArrayList<Integer> array = new ArrayList<>();
    for(int i=0; i< n; i++){
      array.add(Integer.parseInt(br.readLine()));
    }

    Collections.sort(array);

    StringBuilder sb = new StringBuilder();
    for(int arrs: array){
      sb.append(arrs + "\n");
    }
    System.out.println(sb);
  }
}
