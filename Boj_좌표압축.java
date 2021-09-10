
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Boj_좌표압축 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 중복 제거를 위한 Set 사용도 고려해보기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] arr = (br.readLine()).split(" ");
		
		//좌표 리스트
		Map<Integer, Integer> pmap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			pmap.put(i, Integer.parseInt(arr[i]));
		}
		
		List<Entry<Integer, Integer>> list_entries = new ArrayList<Entry<Integer, Integer>>(pmap.entrySet());

		// Value로 정렬
		Collections.sort(list_entries, new Comparator<Entry<Integer, Integer>>() {
			public int compare(Entry<Integer, Integer> obj1, Entry<Integer, Integer> obj2) {
				return obj1.getValue() - obj2.getValue();
			}
		});
		
		//answer로 답 업데이트 - 중복 처리 ( 이전 값과 비교)
		int prev = list_entries.get(0).getValue();
		int index = 0;
		for (Entry<Integer, Integer> entry : list_entries) {
			int cur = entry.getValue();
			if(prev >= cur) {
				entry.setValue(index);
				continue;
			}
			++index;
			prev = cur;
			entry.setValue(index);
		}
		
		//key로 정렬 후 출력
		Collections.sort(list_entries, new Comparator<Entry<Integer, Integer>>() {
			public int compare(Entry<Integer, Integer> obj1, Entry<Integer, Integer> obj2) {
				return obj1.getKey() - obj2.getKey();
			}
		});

		// 결과 출력
		StringBuilder sb = new StringBuilder();
		for(Entry<Integer, Integer> entry : list_entries) {
			sb.append(entry.getValue()+ " ");
		}
		System.out.println(sb.toString().trim());
	}
}
