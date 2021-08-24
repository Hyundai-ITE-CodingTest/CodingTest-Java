package kosa.ex2;

public class day0818ex1 {
	//StringBuilder 이용하여 문자열 생성함.
	//간혹 문자열을 새로 생성하는 경우 문자열을 겹겹이 쌓아서 새로운 문자열을 만들 때 이득이 있는데 여기에서는
	//StringBUilder 연습을 위해 사용해봄
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		//5 번 개행하는데
		//개행을 할때마다 내부의 for문은 반복횟수가 늘어남
		for (int i = 1; i <= 5; i++) {
			for (int j = 0; j < i; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}

		//5번 개행하는데
		// 개행할때 마다 반복 횟수가 1씩 줄어듦
		for (int i = 0; i < 5; i++) {
			for (int j = 5; j > i; j--) {
				sb.append("*");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

}
