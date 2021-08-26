package Quiz;

import java.util.Scanner;

public class Quiz04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input_id = scan.nextLine();
        String output = "";
        for(int i = 0; i < input_id.length(); i++){
            int num = (int)input_id.charAt(i);
            if(num > 119){
                output += (char)(num + 4 - 26);
            }else output += (char)(num + 4);
        }
        System.out.println(output);
    }
}
