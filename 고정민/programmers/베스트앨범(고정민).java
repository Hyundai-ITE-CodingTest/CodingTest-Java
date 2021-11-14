import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
        }
        //많이 재생된 장르 순서대로 배열에 넣기 -> (예 : pop, classic)
        ArrayList<String> genre_sorted = new ArrayList<>();
        while(!map.isEmpty()){
            int max = 0;
            String max_key = "";
            for(String key : map.keySet()){
                if(max < map.get(key)){
                    max = map.get(key);
                    max_key = key;
                }
            }
            genre_sorted.add(max_key);
            map.remove(max_key);
        }
        
        ArrayList<Integer> answer_list = new ArrayList<>();
        //정렬된 장르 내에서 재생횟수대로 2개씩 뽑아서 정렬
        for(String g: genre_sorted){
            int max = 0;
            int firstidx = -1; //첫 번째 인덱스
            int secondidx = -1; //두 번째 인덱스
            //첫 번째 뽑기
            for(int i=0; i<genres.length; i++){
                //장르 내에서 플레이 수가 최댓값인 인덱스를 찾는다
                if(g.equals(genres[i]) && max<plays[i]){
                    max = plays[i];
                    firstidx = i;
                }
            }
            max=0;
            //두 번째 뽑기
            for(int i=0; i<genres.length; i++){
                //장르 내에서 두 번째 플레이수 최댓값인 인덱스를 찾는다
                if(g.equals(genres[i]) && max<plays[i] && firstidx != i){
                    max = plays[i];
                    secondidx = i;
                }
            }
            //첫 번째 인덱스는 무조건 추가
            answer_list.add(firstidx);
            //두 번째 인덱스는 장르에 속한 곡이 하나일 수도 있으므로 secondidx 체크 후 추가
            if(secondidx != -1) answer_list.add(secondidx);
        }
        
        return answer_list;
    }
}
