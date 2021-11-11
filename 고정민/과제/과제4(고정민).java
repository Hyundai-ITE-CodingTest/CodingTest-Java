import java.util.Scanner;
class Main {
 public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
   String pwd = sc.next();
   char[] array = new char[pwd.length()];
   
   for(int i =0; i< pwd.length(); i++){
     int ch = pwd.charAt(i)+4;
     if(ch>122)  array[i] = (char)(pwd.charAt(i)-122+4+97);
     else array[i] = (char)ch;
   }
   
   System.out.println(String.valueOf(array));
   sc.close();
} }
