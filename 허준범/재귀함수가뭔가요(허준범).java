import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());

		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n");
		recursive(n, 0);
		System.out.println(sb);

	}

	// 문자열 반복
	// repeated = new String(new char[n]).replace("\0", s);
	// n은 문자열 s를 몇번 반복할건지에 대한 변수입니다.
	public static void recursive(int n, int depth) {
		String tab = "____";
		tab = new String(new char[depth]).replace("\0", tab);
		if (n == 0) {
			sb.append(tab).append("\"재귀함수가 뭔가요?\"\n");
			sb.append(tab).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			sb.append(tab).append("라고 답변하였지.\n");
			return;
		}
		sb.append(tab).append("\"재귀함수가 뭔가요?\"\n");
		sb.append(tab).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
		sb.append(tab).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
		sb.append(tab).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
		recursive(n - 1, depth + 1);
		sb.append(tab).append("라고 답변하였지.\n");
	}
}