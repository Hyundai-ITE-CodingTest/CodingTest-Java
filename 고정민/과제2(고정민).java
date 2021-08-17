import java.util.Scanner;

class Main {
 public static void main(String[] args) {
   int sum = 0;
   int min = Integer.MAX_VALUE;
   Scanner sc = new Scanner(System.in);
   for(int i = 0; i<7; i++){
     int n = sc.nextInt();
     if(n%2==1){
       sum += n;
       if(min>n) min=n;
     }
   }
   sc.close();
   if(sum==0){
     System.out.print(-1);
     return;
   }else{
     System.out.println(sum);
     System.out.println(min);
   }
} }
