import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

class Solution {
    
    HashMap<String, ArrayList<Integer>> indexMap = new HashMap<>();

	public void makeIndexMap(String index, int n, String[] data) {

		if (n == 4) {
			ArrayList<Integer> value = indexMap.get(index);
			int score = Integer.parseInt(data[4]);
			
			//System.out.println("index " + index + " score " + score);
			//초기화
			if(!indexMap.containsKey(index)) {
				ArrayList<Integer> added = new ArrayList<Integer>();
				added.add(score);
				indexMap.put(index, added);
			}else {
				value.add(score);
				//Collections.sort(value);
			}
			
			return;
		}

		//visited[n] = true;
		
		makeIndexMap(index + "-" , n + 1, data);
		makeIndexMap(index+ data[n], n + 1, data);

		return;
	}

	
    public int[] solution(String[] info, String[] query) {
       
        int[] answerArr = new int[query.length];

       // 데이터 저장
		for (String line : info) {
			String[] data = line.split(" ");
			makeIndexMap("", 0, data);
		}
        
        //정렬
        List<String> list = new ArrayList<>(indexMap.keySet());
        for(int i=0; i<list.size(); i++) {
        	List<Integer> scoreList = indexMap.get(list.get(i));
        	Collections.sort(scoreList);
        }

		// 쿼리 찾기
		int i = 0;
		for (String line : query) {
			String[] options = line.split(" and | ");

			String index = options[0] + options[1] + options[2] + options[3];
			

			//System.out.println("================================ ");
			//System.out.println("query " + result.toString());
            
            if(!indexMap.containsKey(index)){
                answerArr[i] = 0;
                ++i;
                continue;
            }
            
            ArrayList<Integer> result = indexMap.get(index);
			int left = 0;
			int right = result.size() - 1;
			
			int score = Integer.parseInt(options[4]);
			//System.out.println("score " + score);
			
			//이진 탐색
			while(left<=right) {
	            int mid =(left+right)/2;
	            
				if(result.get(mid) <score) {
					left = mid+1;	
				}else {
					right = mid-1;
				}
			}
			
			answerArr[i] = result.size() - left;
			++i;
			// System.out.println("score " + score + " mid " + mid + " answer " +
			// (result.size() - mid));

		}

		// for (int answer : answerArr) {
		// 	System.out.println(answer);
		// }
		 return answerArr;
    }
}
