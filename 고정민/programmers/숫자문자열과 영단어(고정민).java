class Solution {
    public int solution(String s) {
        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		String[] numeric = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		
		for(int i = 0 ; i< nums.length; i++) {
			if(s.contains(nums[i])) {
				s = s.replace(nums[i], numeric[i]);
			}
		}
		
		return Integer.parseInt(s);
    }
}
