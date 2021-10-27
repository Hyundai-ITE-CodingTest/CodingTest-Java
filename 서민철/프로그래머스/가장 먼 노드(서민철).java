import java.util.*;
import java.io.*;

class Solution {
	public class Node {
		int num, dist;
		ArrayList<Node> nodes;
		boolean visited;
	}

	public int solution(int n, int[][] edges) {
		int answer = 0;
		Node[] node = new Node[n + 1];

		for (int i = 1; i <= n; i++) {
			node[i] = new Node();
			node[i].num = i;
			node[i].nodes = new ArrayList<Node>();
			node[i].visited = false;
		}

		for (int[] edge : edges) {
			int a = edge[0];
			int b = edge[1];
			node[a].nodes.add(node[b]);
			node[b].nodes.add(node[a]);
		}

		int maxDist = BFS(node, 1);

		for (int i = 1; i <= n; i++) {
			if (node[i].dist == maxDist) {
				answer += 1;
			}
		}

		return answer;
	}

	public int BFS(Node[] node, int root) {
		int maxDist = 0;

		node[root].visited = true;
		node[root].dist = 0;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node[root]);

		while (!queue.isEmpty()) {
			Node nowNode = queue.poll();

			for (Node nd : nowNode.nodes) {
				if (!nd.visited) {
					nd.visited = true;
					nd.dist = nowNode.dist + 1;
					maxDist = Math.max(maxDist, nd.dist);
					queue.add(nd);
				}
			}
		}

		return maxDist;
	}
}