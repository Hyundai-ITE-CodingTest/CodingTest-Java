class Solution {
	public int solution(int[] stones, int k) {
        int answer = 0;
        left = 0; 
        right = 200000000;
        
        while(left <= right) {
        	int mid = (left+right)/2;
        	
        	if(check(mid,k,stones)) {
        		left = mid+1;
        		answer = mid;
        	}
        	else right = mid-1;
        }
        return answer;
    }

	public boolean check(int mid, int k, int[] stones) {
		int count = 0;
		for(int stone : stones) {
			if(stone < mid) {
				count++;
				if(count>=k) return false;
			}
			else count = 0;
		}
		return true;
	}
}