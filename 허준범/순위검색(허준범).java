import java.util.*; 

class Solution {
    public static HashMap<String, ArrayList<Integer>> infoMap;
    public static int[] answer;
    
    public int[] solution(String[] info, String[] query) {
        answer = new int[query.length];
        
        // SetInfo
        infoMap = new HashMap<>();
        for(int i=0; i < info.length; i++) {
            String[] line = info[i].split(" ");
            dfs("", 0, line);
        }
        
        // 점수 순으로 정렬
        for(String key : infoMap.keySet()) {
            Collections.sort(infoMap.get(key));
        }
        
        // serachQuery
        for(int i=0; i < query.length; i++) {
            StringBuilder sb = new StringBuilder();
            String[] line = query[i].split(" ");
            
            for(int j=0;j<line.length-1;j++){
                if(line[j].equals("and")) continue; 
                sb.append(line[j]);
            }
            
            String key = sb.toString();
            int score = Integer.parseInt(line[line.length-1]);
            answer[i] = counting(key, score);
        }
        
        
        return answer;
    }
    
    // infoMap = { '-frontendsenior-': [100, 120], '--seniorchicken' : [120, 150] } 
    // 위와 같은 형식으로 추가
    public static void dfs(String key, int depth, String[] info) {
        if(depth == 4) {
            if(infoMap.containsKey(key)) {
                infoMap.get(key).add(Integer.parseInt(info[4]));
            } else {
                infoMap.put(key, new ArrayList<>(Arrays.asList(Integer.parseInt(info[4]))));
            }
            return;
        }
        
        dfs(key+"-", depth+1, info);
        dfs(key+info[depth], depth+1, info);
    }
    
    // 이분탐색 score 시작 위치
    public static int counting(String key,int score){
        if(!infoMap.containsKey(key)) 
            return 0;
        
        ArrayList<Integer> scores = infoMap.get(key);
        int start=0;
        int end= scores.size()-1;
        
        while(start <= end){
            int mid=(start+end)/2;
            if(scores.get(mid) < score){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        
        return scores.size()-start;
    }
    
    public static void printInfoMap() {
        for(Map.Entry<String, ArrayList<Integer>> entry : infoMap.entrySet()) {
            String mapKey = entry.getKey();
            System.out.println(mapKey);
            ArrayList<Integer> mapValue = entry.getValue();
            for(int i=0; i < mapValue.size(); i++) {
                System.out.print(mapValue.get(i) + " ");
            }
            System.out.println();
        }
    }
}