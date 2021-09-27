//순차적 탐색 시도시 시간 초과
//정확성과 효율성을 판단하는 문제일 경우, 이진탐색, dp 우선 생각
class Solution {
    public static int solution(int[] stones, int k) {
        int answer = 0;
        int left = 1;
        int right = Integer.MAX_VALUE;

        while (left <= right) {//두개의 지점 
            int mid = (left + right) / 2;
            int result = 0;
            for (int i=0; i<stones.length; i++) {
                if (stones[i] <= mid) {// 범위의 중간값 기준 어디위치?
                    result++;
                } else {
                    result = 0;
                }
                if (result >= k) { //k이상일 경우
                    right = mid - 1; //한칸 앞으로
                    break;
                }
            }
            if (result < k) {
                left = mid + 1;
                answer = left;
            }
        }
        return answer;
    }
}
