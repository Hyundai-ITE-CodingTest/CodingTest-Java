package codingtest;

import java.util.List;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class LRU {

	public static void main(String[] args) {
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		solution(3, cities);
	}
	
	public static int solution(int cacheSize, String[] cities) {
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int time = 0;
        final int cacheMiss = 5;
        final int cacheHit = 1;
        
        for(int i = 0; i < cities.length; i++ ) {
        	String city = cities[i].toLowerCase();
        	
        	/* HIT */
            if(map.containsKey(city)){
                map.put(city, i);
                time += cacheHit;
                continue;
            }else {
            	time += cacheMiss;
            	
            	/* cache size 부족 */
                if(cacheSize <= 0){
                    continue;
                }
            	if(map.size() >= cacheSize) {
            		List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(map.entrySet());
            		Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
            			// compare로 값을 비교
            			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
            				// 오름 차순 정렬
            				return obj1.getValue().compareTo(obj2.getValue());
            			}
            		});
            		String oldest = list_entries.get(0).getKey();
            		map.remove(oldest);
            		map.put(city, i);
            	}else {
            		map.put(city, i);
            	}
            }
        }
        System.out.println(time);
        return time;
    }
}
