import java.util.ArrayList;
import java.util.HashMap;

class Solution {
	public int solution(String str1, String str2) {
		HashMap<String, Integer> map1 = makeSet(str1.toLowerCase());
		HashMap<String, Integer> map2 = makeSet(str2.toLowerCase());

		int intersection = getIntersection(map1, map2);
		int union = getUnion(map1, map2, intersection);

		if(intersection == 0 && union == 0)
		{
			return 65536;
		}
		
		double answer = (double) intersection / (double) union;

		return answer;
	}

	public HashMap<String, Integer> makeSet(String s) {
		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 1; i < s.length(); i++) {
			String t = s.substring(i - 1, i + 1);
			if (t.matches("^[a-z]{2}$")) {
				// 키가 이미 있다면
				if (map.containsKey(t)) {
					map.put(t, map.get(t) + 1);
				} else {
					map.put(t, 1);
				}
			}
		}
		return map;
	}

	public int getIntersection(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
		int result = 0;
		for (String key : map1.keySet()) {
			if (map2.containsKey(key)) {
				// 동일한 키 값이 존재하면 둘 중 작은 값이 교집합에 포함
				result += Math.min(map1.get(key), map2.get(key));
			}
		}
		return result;
	}
	
	public int getUnion(HashMap<String, Integer> map1, HashMap<String, Integer> map2, int intersection) {
		int result = 0;
		for (String key : map1.keySet()) {
			result += map1.get(key);
		}
		
		for (String key : map2.keySet()) {
			result += map2.get(key);
		}
		return result - intersection;
	}
}