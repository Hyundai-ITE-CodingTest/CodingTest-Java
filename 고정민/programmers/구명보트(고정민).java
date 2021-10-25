import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int ans = 0;
        Arrays.sort(people);
		
		int bigIdx = people.length - 1;
		int smallIdx = 0;
		
		while(smallIdx <= bigIdx) {
			if(people[bigIdx] + people[smallIdx] <= limit) smallIdx++;
			bigIdx--;
			ans++;
		}
        return ans;
    }
}
