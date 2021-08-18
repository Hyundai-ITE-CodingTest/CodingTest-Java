package codingtest;

import java.util.List;
import java.util.Map.Entry;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

public class LRU {

	public static void main(String[] args) throws Exception {
		
		/**
		 *  입력값 
		 *  3 10
		 *  hi hello bye hi what bye good smart creative create
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cacheSize = Integer.parseInt(br.readLine().split(" ")[0]);
		String[] cities = br.readLine().split(" ");
//			{"hi" ,"hello" ,"bye", "hi" ,"what" ,"bye" ,"good" ,"smart","creative", "create"};
//			{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
//		{ "hello", "hanwha", "hi", "ok", "hello" } ;
		
		solution(cacheSize, cities);
	}
	
	public static int solution(int cacheSize, String[] cities) {
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int time = 0;
        final int cacheMiss = 3;
        final int cacheHit = 1;
        
        for(int i = 0; i < cities.length; i++ ) {
        	String city = cities[i].toLowerCase();
        	
        	/* HIT */
            if(map.containsKey(city)){
                map.put(city, i);
                time += cacheHit;
                //                System.out.println("cachehit" + " " + city);
                continue;
            }else {
            	time += cacheMiss;
            	//            	System.out.println("cacheMiss" + " " + city);
            	/* cache size 부족 */
                if(cacheSize <= 0){
                    continue;
                }
            	if(map.size() >= cacheSize) {
            		//평균 길이 구하기
            		Iterator<String> ir =  map.keySet().iterator();
            		int sum = 0;
            		int size = map.size();
            		while(ir.hasNext()) {
            			sum += ir.next().length();
            		}
            		int average = sum / size;
            		
            		List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(map.entrySet());
            		Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
            			// compare로 값을 비교
            			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
            				// 오름 차순 정렬
            				return obj1.getValue().compareTo(obj2.getValue());
            			}
            		});
            		int idx = 0;
            		String oldest = list_entries.get(0).getKey();
            		while(oldest.length() > average) {
            			++idx;
            			oldest = list_entries.get(idx).getKey();
            		}
            		//            		System.out.println(oldest + " " + oldest.length() + "average" + " "  + average);
            		
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
