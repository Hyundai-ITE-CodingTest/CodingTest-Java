package week07;

import java.util.*;

public class 뉴스_클러스터링 {
	public static int solution(String str1, String str2) {
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();	
		
		for(int i=0; i<str1.length()-1; i++) {
			if('a' <= str1.charAt(i) && str1.charAt(i) <= 'z')
				if('a' <= str1.charAt(i+1) && str1.charAt(i) <= 'z') {
					list1.add(String.valueOf(str1.charAt(i)) + String.valueOf(str1.charAt(i+1)));
				}
		}
		
		for(int i=0; i<str2.length()-1; i++) {
			if('a' <= str2.charAt(i) && str2.charAt(i) <= 'z')
				if('a' <= str2.charAt(i+1) && str2.charAt(i) <= 'z') {
					list2.add(String.valueOf(str2.charAt(i)) + String.valueOf(str2.charAt(i+1)));
				}
		}
		
		Set<String> set = new LinkedHashSet<String>(list1);
		set.addAll(list2);
		
		
		int inter = 0; //교집합
		int union = 0; //합집합
		
		for(String str : set) {
			union += Math.max(Collections.frequency(list1,str) , Collections.frequency(list2,str));
			inter += Math.min(Collections.frequency(list1,str) , Collections.frequency(list2,str));
		}
	
		if(union == 0) return 65536;
		else return (int)(65536 * inter / union);
	}
	public static void main(String[] args) {
		System.out.println(solution("FRANCE", "french"));
		System.out.println(solution("handshake", "shake hands"));
		System.out.println(solution("aa1+aa2", "AAAA12"));
		System.out.println(solution("E=M*C^2", "e=m*c^2"));
	}
}
