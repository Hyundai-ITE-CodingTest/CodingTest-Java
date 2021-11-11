import java.util.*;
//너무너무너무 어렵따..*

class Solution {
    boolean[] check;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        check = new boolean[n];//체크 여부를 담을 배열
        
        /*check가 false일 경우(아직 탐색하지 못한 네트워크일 경우) 
          computers에 대한 완전탐색 시작*/
        for(int i=0; i<n; i++){
            if(!check[i]){
                dfs(computers, i, check);
                answer++;
            }
        }
        return answer;
    }
    
    //깊이우선탐색..
    //하나의 네트워크로 연결된 노드를 true로 만든다.
    public boolean[] dfs(int[][] computers, int i, boolean[] check){
        check[i] = true;
        for(int j=0; j<computers.length; j++){
            //i컴퓨터에 연결된 또다른 컴퓨터일 경우 연결을 표시해줌
            //1. 자기 자신이 아니어야한다.
            //2. 아직 탐색되지 않은 네트워크에 존재해야한다.
            //3. i와 연결된 컴퓨터이어야한다.
            if(i!=j && check[j]==false && computers[i][j]==1){
                check = dfs(computers, j, check);
            }
        }
        return check;
    }
}