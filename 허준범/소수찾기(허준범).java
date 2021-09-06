import java.util.*;

class Solution {
    public static int n;
    public static boolean[] visited;
    public static HashSet<Integer> primes;
    public static char[] out;
    
    public int solution(String numbers) {
        int answer = 0;
        n = numbers.length();
        visited = new boolean[n];
        primes = new HashSet<>();
        
        // 만들 숫자 1자리부터 n자리까지
        for(int i=1; i <= n; i++) {
            out = new char[i];
            perm(0, i, numbers);
        }
        
        answer = primes.size();
        
        return answer;
    }
    
    // 소수 판별
    public static boolean isPrime(int num) {
        if(num == 1)
            return false;
        
        boolean isPrime = true;
        for(int i=2; i < (int)Math.sqrt(num)+1; i++) {
            if(num % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    } // isPrime
    
    public static void perm(int depth, int m, String numbers) {
        if(depth == m) {
            if(out[0] == '0') // 첫 번째가 0이면 안됨
                return;
            
            int num = Integer.parseInt(String.valueOf(out));
            if(isPrime(num)) // 소수면 set에 추가
                primes.add(num);
            return;            
        }
        
        for(int i=0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                out[depth] = numbers.charAt(i);
                perm(depth+1, m, numbers);
                visited[i] = false;
            }
        }
    } // perm
    
    
}