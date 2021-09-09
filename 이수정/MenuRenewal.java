import java.util.*;
class Solution {
    static ArrayList<String> arr = new ArrayList<>();
    static Map<String, Integer> map = new HashMap<>();
    static ArrayList<String> temp = new ArrayList<>();
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        int len[] = new int[course[course.length-1]+1];
        for(int i = 0; i< orders.length; i++){
            for(int j = 0; j<course.length;j++){
                recursive(orders[i].toCharArray(), course[j], 0, "");
            }

        }
        for (String str : arr) {
            Integer count = map.get(str);
            if (count == null) {
                map.put(str, 1);
            } else {
                map.put(str, count + 1);
            }
        }
        //값의 기준으로 정렬
        List<String> keySetList = new ArrayList<>(map.keySet());
        Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
        for(int i = 0; i< course.length; i++){
            int val = 0;
            for(String key: keySetList){
                if(key.length() == course[i] && map.get(key) > 1){
                    if(map.get(key) >= val){
                        temp.add(key);
                        val = map.get(key);
                    }
                }
            }
        }
        Collections.sort(temp);
        answer = temp.toArray(new String[temp.size()]);
        return answer;
    }
    
    static void recursive(char[] str, int r, int next , String result){
        Arrays.sort(str);
        if(r == 0){//base case
            arr.add(result);
            return;
        }else{
            for(int i = next; i < str.length; i++){
                recursive(str, r-1, i+1, result+str[i]);
            }
        }
    }
}
