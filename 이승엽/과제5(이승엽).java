public class no01 {

	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			int num = i+1;
			if(i > 4) {
				num = 5- (i+1)%6;
			}
			for(int j = 0; j < num; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}