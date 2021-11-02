package week13;

import java.io.*;
import java.util.*;

public class 마법사상어와파이어볼 {
	static List<Fireball>[][] fireball;
	static List<Fireball> list = new ArrayList<>();
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		fireball = new List[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				fireball[i][j] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			list.add(new Fireball(r - 1, c - 1, m, s, d));
		}

		System.out.println(solution(N, K));
	}

	static int solution(int N, int K) {
		int answer = 0;

		for (int k = 0; k < K; k++) {
			for (Fireball cur : list) {
				int ny = (cur.y + N + dy[cur.d] * (cur.s % N)) % N; // 1 과 N이 연결되어 있어서
				int nx = (cur.x + N + dx[cur.d] * (cur.s % N)) % N; // 범위를 벗어났을때 연산

				cur.y = ny;
				cur.x = nx;

				fireball[ny][nx].add(cur); //list에 있는 볼을 fireball로 이동
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (fireball[i][j].size() == 1)
						fireball[i][j].clear();
					if (fireball[i][j].size() < 2)
						continue;

					int mSum = 0; //질량 합
					int sSum = 0; //방향 합

					boolean even = fireball[i][j].get(0).d % 2 == 0 ? true : false;// 짝수면 참
					boolean odd = fireball[i][j].get(0).d % 2 == 1 ? true : false; // 홀수면 참

					for (Fireball cur : fireball[i][j]) {
						mSum += cur.m;
						sSum += cur.s;
						even = even && cur.d % 2 == 0 ? true : false; //계속 짝수면 참
						odd = odd && cur.d % 2 == 1 ? true : false; //계속 홀수면 참
						list.remove(cur); //겹쳐진 볼들은 값들이 바껴서 리스트에서 삭제
					}

					int newM = mSum / 5;
					int size = fireball[i][j].size();
					fireball[i][j].clear();

					if (newM == 0)
						continue;
					int newS = sSum / size;

					if (even | odd) { //둘중에 하나라도 참이면(모두 홀수이거나 모두 짝수이면)
						for (int d = 0; d < 8; d += 2) { // 0 2 4 6
							list.add(new Fireball(i, j, newM, newS, d));
						}
					} else {
						for (int d = 1; d < 8; d += 2) { // 1 3 5 7
							list.add(new Fireball(i, j, newM, newS, d));
						}
					}
				}
			}
		}

		for (Fireball cur : list)
			answer += cur.m;

		return answer;
	}
}

class Fireball {
	int y;
	int x;
	int m; // 질량
	int s; // 방향
	int d; // 속력

	public Fireball(int y, int x, int m, int s, int d) {
		super();
		this.y = y;
		this.x = x;
		this.m = m;
		this.s = s;
		this.d = d;
	}

}
