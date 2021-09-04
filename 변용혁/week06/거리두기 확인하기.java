package week06;

import java.util.*;

public class 거리두기확인하기 {
    public int[] solution(String[][] places) {
    	int len = places.length;
        int[] answer = new int[len];
        
        for(int i=0; i<len; i++) {
        	answer[i] = Distancing(places[i]);
        }
        
        return answer;
    }
    
    public static int Distancing(String[] place) {
    	List<int[]> candidates = new ArrayList<int[]>();
    	
    	for(int i=0; i<5; i++) {
    		for(int j=0; j<5; j++) {
    			if(place[i].charAt(j) == 'P') {
    				int[] candidate = {i, j};
    				candidates.add(candidate); //응시자들 좌표
    			}
    		}
    	}
    	int len = candidates.size();
    	
    	for(int i=0; i<len; i++) {//응시자들간 거리 계산
    		for(int j=i+1; j<len; j++) {
    			int[] c1 = candidates.get(j);
    			int[] c2 = candidates.get(i);
    			int dist = Math.abs(c1[0]-c2[0]) + Math.abs(c1[1]-c2[1]);
    			
    			if(dist == 1) { //거리가 1이면 바로끝
    				return 0;
    			}else if(dist == 2) { //거리가 2면 사이에 파티션이 있는지 확인
    				int miny = Math.min(c1[0], c2[0]);
    				int maxy = Math.max(c1[0], c2[0]);
    				int minx = Math.min(c1[1], c2[1]);
    				int maxx = Math.max(c1[1], c2[1]);
    				
    				for(int r=miny; r<=maxy; r++) { // 2x2 1x2
    					for(int c=minx; c<=maxx; c++) {
    						if(place[r].charAt(c) == 'O')
    							return 0;
    					}
    				}
    			}
    		}
    	}
    	
		return 1;    	
    }
}
