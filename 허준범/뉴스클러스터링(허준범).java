import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        ArrayList<String> setA = new ArrayList<>();
        ArrayList<String> setB = new ArrayList<>();
        
        // 두 글자씩 추출
        for(int i=0; i < str1.length()-1; i++) 
            setA.add(str1.substring(i, i+2));
        for(int i=0; i < str2.length()-1; i++)
            setB.add(str2.substring(i, i+2));
        
        // 공백, 특수문자 제거
        String pattern = "^[a-zA-Z]*$"; // 문자열만 가능
        // list for문 돌면서 삭제할려면 iterator 사용
        Iterator iter = setA.iterator(); 
        while(iter.hasNext()) { 
            String str = (String)iter.next();
            if(!str.matches(pattern)) { 
                iter.remove();
            }
        }

        iter = setB.iterator();
        while(iter.hasNext()) { 
            String str = (String)iter.next();
            if(!str.matches(pattern)) { 
                iter.remove();
            }
        }
        
        
        // 대소문자 소문자로 통일, 카운트
        HashMap<String, Integer> setAcount = new HashMap<>();
        HashMap<String, Integer> setBcount = new HashMap<>(); 
        
        for(int i=0; i < setA.size(); i++) {
            String lowerCase = setA.get(i).toLowerCase();
            setA.set(i, lowerCase);
            setAcount.put(lowerCase, setAcount.getOrDefault(lowerCase, 0) + 1);
        }
            
        for(int i=0; i < setB.size(); i++) {
            String lowerCase = setB.get(i).toLowerCase();
            setB.set(i, lowerCase);
            setBcount.put(lowerCase, setBcount.getOrDefault(lowerCase, 0) + 1);
        }
        
        HashMap<String, Integer> setIntersaction = new HashMap<>();
        HashMap<String, Integer> setUnion = new HashMap<>();
        
        // 교집합 찾기
        for(String key : setAcount.keySet()) {
            if(setBcount.containsKey(key)) 
                setIntersaction.put(key, Math.min(setAcount.get(key), setBcount.get(key)));
        }
        // 합집합 찾기
        for(Map.Entry<String, Integer> entry : setBcount.entrySet()) {
            setUnion.put(entry.getKey(), entry.getValue());
        }
        for(String key : setAcount.keySet()) {
            if(setUnion.containsKey(key)) {
                setUnion.put(key, Math.max(setAcount.get(key), setUnion.get(key)));
            } else {
                setUnion.put(key, setAcount.get(key));
            }
        }
        
        // 소수 구하려면 double 타입 사용해야됨
        double intersaction = 0;
        double union = 0;
        for(Integer val : setIntersaction.values())
            intersaction += val;
        for(Integer val : setUnion.values())
            union += val;
        
        
        if(intersaction == 0 && union == 0) {
            answer = 1 * 65536;
        } else {
            answer = (int)(intersaction / union * 65536);
        }
        
        return answer;
    }
}