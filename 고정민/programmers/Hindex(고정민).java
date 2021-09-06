package boj.sorting;

import java.util.Arrays;
import java.util.Collections;

public class Hindex {
	public static void main(String[] args) {
		Integer[] citations = {3,0,6,1,5};
		
		int answer = 0;
        
		Arrays.sort(citations, Collections.reverseOrder());
		for(int i = 0; i<citations.length;i++){
            if((i+1)>citations[i]) {
            	answer = i;
            	break;
            }
        }
		
		System.out.print(answer);
        
	}
}
