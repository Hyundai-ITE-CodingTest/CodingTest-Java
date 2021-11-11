import java.util.Scanner;

class Main {
 public static void main(String[] args) {
   int result=1;
   Scanner sc = new Scanner(System.in);
   for(int i = 0; i<3; i++){
     int n = sc.nextInt();
     result *= n;
   }
   sc.close();
   int[] array = new int[10];
   while(result>0){
     array[result%10]++;
     result /= 10;
   }
   for(int arrays : array){
     System.out.println(arrays);
} }
}
