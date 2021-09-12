import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Student> sortedStds = new ArrayList<>();

		// input 처리
		for (int i = 0; i < N; i++) {
			String[] inputs = br.readLine().split(" ");
			sortedStds.add(new Student(inputs[0], Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2]),
					Integer.parseInt(inputs[3])));
		}

		Collections.sort(sortedStds, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				int firstResult = s2.getKorScore() - s1.getKorScore();

				if (firstResult == 0) {
					int secResult = s1.getEngScore() - s2.getEngScore();

					if (secResult == 0) {
						int thirdResult = s2.getMathScore() - s1.getMathScore();

						if (thirdResult == 0) {
							return s1.getName().compareTo(s2.getName());
						}
						return thirdResult;
					}
					return secResult;
				}
				return firstResult;
			}
		});

		StringBuilder sb = new StringBuilder();
		for (Student student : sortedStds) {
			sb.append(student.getName() + "\n");
		}
		System.out.println(sb.toString().trim());

	}

}

class Student {
	private String name;
	private int korScore, engScore, mathScore;

	Student(String name, int korScore, int engScore, int mathScore) {
		this.name = name;
		this.korScore = korScore;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}

	public String getName() {
		return name;
	}

	public int getEngScore() {
		return engScore;
	}

	public int getKorScore() {
		return korScore;
	}

	public int getMathScore() {
		return mathScore;
	}

}
