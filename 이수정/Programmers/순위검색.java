//완전탐색 -> 시간초과 50억 -> 이분탐색
import java.util.*;
class Solution {
    static Map<String, ArrayList<Integer>> map; //map에 리스트를 넣을수 있는 것을 기억
    //info에 대한 조합, 점수
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();
        //조건을 만족하는 사람이 몇명인가 출력 => 조합
        String[][] info_arr = new String[info.length][];
        //query를 만족하는 info의 수가 몇인지
        for(int i = 0; i < info.length; i++){
            info_arr[i] = info[i].split(" ");
            Combination("", 0, info_arr[i]);
        }
        //map에 저장한 점수 오름차순 정렬을 위해서
        for(String key :map.keySet()) {
        	Collections.sort(map.get(key));
        }
        for(int i = 0; i < query.length; i++){
            query[i] = query[i].replaceAll(" and ", "");
            String[] str = query[i].split(" "); //---- 150
            int score = Integer.parseInt(str[1]);
            answer[i] = BinarySearch(str[0], score);
        }
        return answer;
    }
    static void Combination(String str, int depth, String[] info){
        //재귀
        if(depth == 4){ //4번째 위치한 점수를 저장하기 위해
            int score = Integer.parseInt(info[depth]);
            if(map.containsKey(str)){
                map.get(str).add(score);
            }else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(score);
                map.put(str,temp);
            }
            return;
        }
        Combination(str + "-", depth + 1, info);
        Combination(str + info[depth], depth + 1, info);
    }
    static int BinarySearch(String str, int score){
        //점수(value)로 정렬한 리스트에서 일정 점수 이상인 사람 찾기
        if(map.containsKey(str)){
            List<Integer> list = map.get(str);
            int left = 0; int right = list.size() -1;
            while(left <= right){
                int mid = (left+ right)/2;
                if(list.get(mid) < score){
                    left = mid +1;
                }else{
                    right = mid -1;
                }
            }
            return list.size() - left;
        }

        return 0;
    }
    
}
