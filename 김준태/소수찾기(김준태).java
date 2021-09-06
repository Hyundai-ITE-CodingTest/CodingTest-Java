import java.util.ArrayList;

class Solution {
    static int answer = 0;
    static boolean[] check = new boolean[7];
    static ArrayList<Integer> arr = new ArrayList<>();

    // 1~n 자리의 정수를 조합하기 위한 재귀함수
    public static void rec(String n, String temp, int len){
        // temp의 길이가 len(만들어져야 하는 길이)가 되었을 때 true
        if(temp.length() == len){
            // 중복 검사 후 추가
            if(!arr.contains(Integer.parseInt(temp))) {
                arr.add(Integer.parseInt(temp));
            }
        }
        
        // n으로 전달된 numbers 탐색
        for(int j = 0; j < n.length(); j++){
            if(check[j]) continue;
            // temp에 숫자를 붙혀나감
            temp += n.charAt(j);
            check[j] = true; 
            
            // 재귀 호출 현재 몇자리의 수를 만드는지에 대한 정보 len
            rec(n, temp, len);
            // 조합이 완료되면 직전의 방문처리한 인덱스 false???
            check[j] = false;
            // temp 변수에서 마지막 자리의 숫자를 제외하고 갱신
            temp = temp.substring(0, temp.length()-1);
        }
    }
    
    public static void cal(int n){
        if(n==0 || n==1) return;
        
        // 소수 판별 2~n의 제곱근(Math.sqrt(n)) 까지 돌면서 나누어 떨어지면 소수 X
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n%i == 0) return;
        }
        
        answer++;
        
    }
    
    public int solution(String numbers) {
        String temp = "";
        
        // 몇 자리의 수를 만들 지에 대한 반복
        for(int i = 1; i <= numbers.length(); i++){
            rec(numbers, temp, i);
        }
        
        // 만들어진 조합의 수가 담긴 ArrayList탐색
        for(int x : arr){
            cal(x);
        }
        
        return answer;
    }
}
// https://fbtmdwhd33.tistory.com/227 참고
