import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

class Member {
	Member(int age, String name, int idx) {
		this.age = age;
		this.name = name;
		this.idx = idx;
	}

	int age;
	String name;
	int idx;
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		ArrayList<Member> mem = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			mem.add(new Member(age, name, i));
		}

		mem.sort(new Comparator<Member>() {
			@Override
			public int compare(Member o1, Member o2) {
				if (o1.age < o2.age) {
					return -1;
				} else if (o1.age > o2.age) {
					return 1;
				} else {
					if (o1.idx < o2.idx)
						return -1;
					else
						return 1;
				}
			}
		});

		StringBuilder st = new StringBuilder();
		for (Member m : mem) {
			st.append(m.age).append(' ').append(m.name).append('\n');
		}

		System.out.println(st);
	}
}
