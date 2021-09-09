import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
	char[] courseName = new char[11];

	public String[] solution(String[] orders, int[] course) {
		ArrayList<String> arr = new ArrayList<String>();

		for (int size : course) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			int maxVal = 0;

			for (String od : orders) {
				DFS(sortString(od), size, size, 0, map);
			}
			for (String key : map.keySet()) {
				maxVal = Math.max(maxVal, map.get(key));
			}
			if (maxVal >= 2) {
				for (String key : map.keySet()) {
					if (map.get(key) == maxVal) {
						arr.add(key);
					}
				}
			}
		}

		String[] answer = arr.toArray(new String[arr.size()]);
		Arrays.sort(answer);

		return answer;
	}

	public String sortString(String s) {
		char[] tmp = new char[s.length()];
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = s.charAt(i);
		}
		Arrays.sort(tmp);
		return new String(tmp);
	}

	public void DFS(String order, int depth, int maxVal, int start, HashMap<String, Integer> map) {
		if (depth == 0) {
			String res = "";
			for (int i = maxVal; i > 0; i--) {
				res += courseName[i];
			}
			addKey(map, res);

			return;
		}

		for (int i = start; i < order.length(); i++) {
			courseName[depth] = order.charAt(i);
			DFS(order, depth - 1, maxVal, i + 1, map);
		}
	}

	public void addKey(HashMap<String, Integer> map, String s) {
		if (map.containsKey(s)) {
			map.put(s, map.get(s) + 1);
		} else {
			map.put(s, 1);
		}
	}
}