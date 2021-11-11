package 국영수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static class Student{
		int kor;
		int eng;
		int math;
		String name;
		
		public Student(String name, int kor, int eng, int math) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
	}
	
	public static void main(String[] args) throws Exception{
		PriorityQueue<Student> pq = new PriorityQueue<>(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				if(o2.kor==o1.kor) {
					if(o2.eng == o1.eng) {
						if(o2.math==o1.math) {
							return o1.name.compareTo(o2.name);
						}
						return o2.math - o1.math;
					}
					return o1.eng-o2.eng;
				}
				return o2.kor-o1.kor;
			}
		});
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			
			pq.add(new Student(name, kor, eng, math));
		}
		
		for(int i=0; i<n; i++) {
			System.out.println(pq.poll().name);
		}
		
	}
}
