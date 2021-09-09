class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        recur(0, 0, numbers, target);
        return answer;
    }
    
    public void recur(int index, int sum, int[] numbers, int target){
        if(index==numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }
        recur(index+1, sum - numbers[index], numbers, target);
        recur(index+1, sum + numbers[index], numbers, target);
    }
}
