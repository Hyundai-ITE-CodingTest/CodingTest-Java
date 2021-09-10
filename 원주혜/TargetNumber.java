class Solution {
    static int maxDepth;
	static int[] Snumbers;
	static int Starget;
	static int answer;
	
    public int solution(int[] numbers, int target) {
        Snumbers = numbers;
		maxDepth = numbers.length;
        Starget = target;
        
        dfs(0, 0);
        
        System.out.println(answer);
        return answer;
    }
    
    public int dfs(int depth, int sum) {
		if(depth == maxDepth) {
			if(sum == Starget) {
			    answer += 1;
			}
			return 1;
		}
		
		int cur = Snumbers[depth];
		dfs(depth+1, sum + cur);
		dfs(depth+1, sum - cur);
		
		return 1;
	}
}
