import java.util.*;
class Solution {
    static int count = 51;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];
        
        count = DFS(visited, 0, begin, target, words);
        //배열안에 동일 단어가 없는 경우 0을 리턴하기 위함.
        if(count == 51){
            count = 0;
        }
        answer = count;
        return answer;
    }
    public static int DFS(boolean[] visit, int cnt, String begin, String target, String[] words){
        
		if(begin.equals(target)){ //동일 단어가 된다면
			if(count > cnt){ //max로 최대값 잡아둠
                count = cnt;
            }
		}
		
        //단어집합에 존재하는 단어일 경우
		for(int i=0; i<words.length; i++){
			if(visit[i] == false && checked(begin, words[i])){ //확인하지 않은 단어, 1단어만 변경이라면
				visit[i] = true;
                //begin 값을 1단어 변경으로 true된 단어로 치환
				DFS(visit, cnt+1, words[i], target, words);
				visit[i] = false;
			}
		}
        return count;
		
	}
	//단어 비교
	public static boolean checked(String begin, String target){
        //1단어만 변경해야하는지
		int change = 0;
        
		for(int i= 0; i < begin.length(); i++){//위치 다른 글자 있을 경우 증가
			if(begin.charAt(i) != target.charAt(i)) change++;
		}
        //1단어만 변경이라면
		if(change==1) return true;
		
		return false;
	}

}
