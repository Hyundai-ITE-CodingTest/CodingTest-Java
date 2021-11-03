class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, target, 0, 0);
        return answer;
    }
    public int dfs(int[] numbers,int target, int depth, int sum ){
        if(depth == numbers.length){//숫자 담긴 배열 다 확인 했을 때,
            if(target == sum) return 1; // 타겟 넘버랑 연산 값이 같으면
            else return 0;
        }else{
            return dfs(numbers, target, depth + 1, sum + numbers[depth]) +
                dfs(numbers, target, depth + 1, sum - numbers[depth]); 
        }
    }
}
