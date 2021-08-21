
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
//import java.util.Scanner;

public class MovieDirector {
    public static void main(String[] args) throws IOException {
/*        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();*/
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        ArrayList<String> list = new ArrayList<String>();
        list.add("666");
        for(int i = 1; i< N; i++){
            list.add(String.valueOf(i)+list.get(0));
        }
        System.out.println(list.get(N-1));
    }
}
