import java.util.*;
import java.io.*;

class Solution {
	public class Edge implements Comparable<Edge> {
		int node1, node2, weight;

		public Edge(int n1, int n2, int w) {
			this.node1 = n1;
			this.node2 = n2;
			this.weight = w;
		}

		@Override
		public int compareTo(Edge e) {
			return Integer.compare(this.weight, e.weight);
		}

		@Override
		public String toString() {
			String ret = "(" + String.valueOf(this.node1) + " ¡ê " + String.valueOf(this.node2) + ") = "
					+ String.valueOf(this.weight);
			return ret;
		}
	}

	public int solution(int n, int[][] costs) {
		int answer = 0;
		int[] parent = new int[n];
		Edge[] edges = new Edge[costs.length];

		for (int i = 0; i < costs.length; i++) {
			edges[i] = new Edge(costs[i][0], costs[i][1], costs[i][2]);
		}

		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		Arrays.sort(edges);

		for (Edge edge : edges) {
			if (parent[edge.node1] != parent[edge.node2]) {
				int a = find(edge.node1, parent);
				int b = find(edge.node2, parent);

				if (a != b) {
					answer += edge.weight;
					union(a, b, parent);
				}
			}
		}

		return answer;
	}

	public int find(int a, int[] parent) {
		if (a == parent[a]) {
			return a;
		}

		return parent[a] = find(parent[a], parent);
	}

	public void union(int a, int b, int[] parent) {
		if (a > b) {
			parent[a] = b;
		} else {
			parent[b] = a;
		}
	}
}