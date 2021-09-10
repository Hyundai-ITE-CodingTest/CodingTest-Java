package week07;

import java.util.*;

public class 메뉴리뉴얼 {

	private static List<String> combination;

	public static String[] solution(String[] orders, int[] course) {
		String[] answer;
		combination = new ArrayList<>();

		for (int i = 0; i < orders.length; i++) { 
			char[] orders_char = orders[i].toCharArray(); 
			Arrays.sort(orders_char); //순열 x 조합이기 때문에 정렬

			for (int index = 0; index < orders_char.length - 1; index++) { //배열마다
				for (int j = 0; j < course.length; j++) { //코스 갯수마다
					dfs(orders_char, index, 1, course[j], String.valueOf(orders_char[index])); //combination에 추가
				}
			}
		}

		Map<String, Integer> map = new HashMap<>();
		for (String key : combination) {
			map.put(key, map.getOrDefault(key, 0) + 1); //map에 넣어주면서 겹치는 주문 세기
		}
		List<String> keySetList = new ArrayList<>(map.keySet());
		Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

		List<String> ansList = new ArrayList<>();
		for (int i = 0; i < course.length; i++) {
			int max_value = 0;

			for (String key : keySetList) {
				if (map.get(key) >= 2 && key.length() == course[i]) { //주문이 2번이상 && 메뉴갯수가 course길이가 같으면
					if (map.get(key) >= max_value) {
						ansList.add(key);
						max_value = map.get(key);
					}
				}
			}
		}
		Collections.sort(ansList); //오름차순 정렬
		answer = new String[ansList.size()];
		ansList.toArray(answer); //list -> array

		return answer;
	}

	public static void dfs(char[] arr, int idx, int length, int course, String str) {
		if (length == course) { 
			combination.add(str);
		}

		for (int i = idx + 1; i < arr.length; i++) {
			dfs(arr, i, length + 1, course, str + arr[i]);
		}
	}

	public static void main(String[] args) {
		System.out.println(solution(new String[] { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" }, new int[] { 2, 3, 4 }));
		System.out.println(solution(new String[] { "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD" }, new int[] { 2, 3, 5 }));
		System.out.println(solution(new String[] { "XYZ", "XWY", "WXA" }, new int[] { 2, 3, 4 }));
	}
}
