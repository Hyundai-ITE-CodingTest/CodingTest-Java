import java.util.Scanner;

public class no04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String answer = "";
		for(int i = 0; i < str.length();i++) {
			int num = (str.charAt(i)+4)%'a';
			answer += (char)(num+'a');
		}
		System.out.println(answer);
	}

}
