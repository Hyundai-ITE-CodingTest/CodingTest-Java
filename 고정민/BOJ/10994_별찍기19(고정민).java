import java.util.Scanner;

class Main {
  static char[][] array = new char[397][397];

  public static void main(String[] args) {
    int n = new Scanner(System.in).nextInt();
    
    for(int i=0;i<4*n-3;i++){
      for(int j=0;j<4*n-3;j++){
        array[i][j] = ' ';
      }
    }
    recur(n, 0, 0);

    for(int i=0;i<4*n-3;i++){
      for(int j=0;j<4*n-3;j++){
        System.out.print(array[i][j]);
      }
      System.out.println();
    }
  }
  public static void recur(int n, int start_x, int start_y){
    if(n==1){
      array[start_x][start_y] = '*';
      return;
    }
    for(int i=0; i<4*n-3; i++){
      if(i==0 || i==4*n-3-1){
        for(int j=0; j<4*n-3; j++){
          array[i+start_x][j+start_y] = '*';
        }
      }else{
        array[i+start_x][start_y] = '*';
        array[i+start_x][start_y +((4*n)-3)-1] = '*';
      }
    }
    recur(n-1, start_x+2, start_y+2);
  }
}
