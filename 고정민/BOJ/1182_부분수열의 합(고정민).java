import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static int n;
  static int s;
  static ArrayList<Integer> arr;
  static int cnt = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    s = Integer.parseInt(st.nextToken());
    arr = new ArrayList<>();

    StringTokenizer st2 = new StringTokenizer(br.readLine());
    for(int i = 0 ; i<n; i++){
       arr.add(Integer.parseInt(st2.nextToken()));
    }
    sum(0,0);
    if(s==0)  cnt--; //s가 0이라면 공집합을 제외해줘야 함
    System.out.print(cnt);
  }
  
  /*
   int current : 현재 인덱스
   int total : 현재 내가 택한 수열의 합
  */
  public static void sum(int current, int total){
    if(current == n){ //수열의 끝까지 탐색했는지 확인
      if(total==s){ //끝까지 탐색했는데 total이 내가 원하는 값과 같으면 cnt++
        cnt++;
      }
      return;
    }
    sum(current+1, total);//현재 원소를 추가하지 않는 경우
    sum(current+1, total+arr.get(current)); //현재 원소를 추가하는 경우
  }
}
