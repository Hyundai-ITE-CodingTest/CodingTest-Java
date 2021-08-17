import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		Person[] p = new Person[n];
		int[] score = new int[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			p[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		for(int i = 0; i < n; i++) {
			for(int j = i+1; j < n; j++) {
				if(p[i].height > p[j].height && p[i].weight > p[j].weight) {
					score[j]++;
				}
				
				if(p[i].height < p[j].height && p[i].weight < p[j].weight) {
					score[i]++;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.print(score[i]+1+" ");
		}
	}

	static class Person {
		int height, weight;

		public Person(int h, int w) {
			height = h;
			weight = w;
		}
	}
}