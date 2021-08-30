import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static int min = 64;
  public static boolean arr[][];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m  = Integer.parseInt(st.nextToken());
    
    arr = new boolean[n][m];
    for(int i=0;i<n;i++){
      String s = br.readLine();
      for(int j=0;j<m;j++){
        if(s.charAt(j)=='W')  arr[i][j] = true;
        else arr[i][j] = false;
      }
    }
    int index_n = n-7;
    int index_m = m-7;
    for(int i=0;i<index_n;i++){
      for(int j=0; j<index_m;j++){
        search(i,j);
      }
    }
    System.out.print(min);
  }
  public static void search(int x, int y){
    int x_end = x+8;
    int y_end = y+8;
    int cnt = 0;

    boolean value = arr[x][y];
    for(int i=x;i<x_end;i++){
      for(int j=y;j<y_end;j++){
        if(arr[i][j] != value)
          cnt++;
        value = !value;
      }
      value = !value;
    }

    cnt = Math.min(cnt, 64-cnt);
    min = Math.min(min, cnt);
  }
}
