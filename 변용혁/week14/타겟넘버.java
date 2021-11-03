class Solution {
    static int[] nums;
    static int tar;
    static int answer;
    static int len;
    public int solution(int[] numbers, int target) {
        nums = numbers;
        tar = target;
        len = numbers.length;
        
        DFS(0,0);
        
        return answer;
    }
    public void DFS(int index, int sum){
        if(index == len){
            if(tar == sum){
                answer++;
            }
            return;
        }
        
        DFS(index+1, sum + nums[index]);
        DFS(index+1, sum - nums[index]);
    }
}
