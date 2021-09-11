import java.util.HashSet;

class Solution {
	int[] parent = new int[200];

	public int solution(int n, int[][] computers) {
		HashSet<Integer> parentSet = new HashSet<Integer>();

		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j) {
					if (computers[i][j] == 1) {
						union(parent[i], parent[j]);
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			parentSet.add(getParent(i));
		}

		return parentSet.size();
	}

	public int getParent(int a) {
		if (a == parent[a]) {
			return a;
		}

		return getParent(parent[a]);
	}

	public void union(int a, int b) {
		int parentA = getParent(a);
		int parentB = getParent(b);

		if (parentA != parentB) {
			if (parentA < parentB) {
				parent[b] = parentA;
			} else {
				parent[a] = parentB;
			}
		}
	}
}