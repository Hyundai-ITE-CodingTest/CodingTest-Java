import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        ArrayList<Post> list = new ArrayList<>();
        Post check = null;
        
        for(int i = 0;i < priorities.length; i++){
            list.add(new Post(priorities[i]));
            if(i == location){
                check = list.get(i);
            }
        }
        
        while(!list.isEmpty()){
            int max = max(list);     
            int size = list.size();
            int i = 0;
            while(true){
                if(list.get(i).p < max){ // 최대값보다 작을 경우
                    Post temp = list.get(i);
                    list.remove(0); // 제거 후
                    list.add(temp); // 맨 뒤에 추가
                    i--; // remove 사용시 변경된 index를 맞추기 위해 추가
                }else{// 최대값보다 크거나 같을 경우
                    if(check == list.get(i)){
                        return answer;
                    }else{
                        list.remove(i);
                        answer++;
                        break;
                    }
                }
                i++;
            }
        }
        return answer;
    }
    
    class Post{
        int p;
        public Post(int p){
            this.p = p;
        }
    }
    
    static int max(ArrayList<Post> li){
        int max = 0;
        for(int i = 0; i < li.size(); i++){
           if(max < li.get(i).p){
               max = li.get(i).p;
           }
        }
        
        return max;
    }
}