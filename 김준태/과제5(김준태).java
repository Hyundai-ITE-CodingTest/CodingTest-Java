package quiz;

public class Quiz_01 {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			if(i >= 5) {
				for(int j = 0; j <= 9-i; j++) {
					System.out.print("*");
				}
			}else {
				for(int j = 0; j <= i; j++) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}
