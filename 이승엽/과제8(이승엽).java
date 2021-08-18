import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class no04 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<String> list = new ArrayList<>();
		int n, w, time = 0, wordsLength = 0;
		double avgLength = 0; // 암기하고 있는 단어들의 평균 길이
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < w; i++) {
			String temp = st.nextToken();
			
			if(list.contains(temp)) { // 단어를 암기하고 있는 경우, 1초 추가, 마지막 순서로 이동
				time++;
				list.remove(temp); 
				list.add(temp);
			}else { // 머릿속에 없는 경우
				if(list.size() == n) {
					int num = 0;
					while(num < n) {
						if(list.get(num).length() <= avgLength) {
							break;
						}
						num++;
					}
					wordsLength -= list.get(num).length();
					list.remove(num);
				}
				
				time += 3;
				list.add(temp);
				wordsLength += temp.length();
				avgLength = wordsLength / list.size();
			}
		}
		System.out.println(time);

	}

}
