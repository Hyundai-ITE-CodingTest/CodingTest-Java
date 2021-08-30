package week06;

import java.io.*;
import java.util.*;

public class 바이러스_2606 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int com = Integer.parseInt(br.readLine());
		int comNet = Integer.parseInt(br.readLine());
		
		int[][] net = new int[com+1][com+1];
		int[] visited = new int [com+1];
		
		for(int i=0; i<comNet; i++) {
			String[] temp = br.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			net[a][b] = 1;
			net[b][a] = 1;
		}
		
		Queue<Integer> que = new LinkedList<Integer>(); //BFS 큐 생성
		que.add(1); //시작점
		visited[1] = 1; //1이면 방문한거
		int answer = 0;
		
		while(que.size() != 0) {
			int temp = que.poll(); //큐에서 한개 꺼내서
			
			for(int i=1; i<=com; i++) {
				if(net[temp][i] == 1 && visited[i] == 0) { //방문 안했고 연결된 컴퓨터 큐에 삽입
					que.add(i);
					visited[i] = 1;
					answer++; //연결된 갯수 증가
				}
			}
		}
		System.out.println(answer);
		
	}
}
