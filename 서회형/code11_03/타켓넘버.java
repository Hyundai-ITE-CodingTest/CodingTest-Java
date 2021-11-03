class Solution {
    int [] numbers;
    int target;
    int answer = 0;
    public int solution(int[] numbers, int target) {
        
        this.numbers = numbers;
        this.target = target;
        dfs(0,0);
        
        return answer;
    }
    public void dfs(int nodeIndex, int sum){
        if(nodeIndex == numbers.length){
            if(sum == target) answer++;
        }else{
            dfs(nodeIndex+1, sum+numbers[nodeIndex]);
            dfs(nodeIndex+1, sum-numbers[nodeIndex]);
        }
    }
}
