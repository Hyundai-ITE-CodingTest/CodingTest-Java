import java.util.Scanner;
import java.io.*;

public class Main{
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {
      int n = new Scanner(System.in).nextInt();
      bw.write((int)Math.pow(2,n)-1+"\n"); //경우의 수는 n^2-1
      recur(n, 1, 3);
      bw.flush();
    
    }
  
  //recur(int n 현재 원판의 개수, from 현재 위치, to 목적 위치)
  public static void recur(int n, int from, int to) throws IOException{
    if(n==1){
      bw.write(from+" "+to+"\n");
      return;
    }else{
      recur(n-1, from, 6-from-to);
      bw.write(from+" "+to+"\n");
      recur(n-1, 6-from-to, to);
    }
  }
}
