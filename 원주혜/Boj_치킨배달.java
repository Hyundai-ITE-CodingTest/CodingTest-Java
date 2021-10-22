import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Main {

	static ArrayList<Position> houses = new ArrayList<>();
	static ArrayList<Position> chickens = new ArrayList<>();
	static int N, M;
	static int cityDist = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = (br.readLine()).split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		for(int i = 0 ; i < N; i++) {
			String[] line = (br.readLine()).split(" ");
			for(int j =0; j < N; j++) {
				//가정집
				if(line[j].equals("1")) {
					houses.add(new Position(i, j));
				}
				//치킨집
				else if(line[j].equals("2")) {
					chickens.add(new Position(i, j));
				}
			}
		}
		
		//치킨집 선택하기
		/*
		 * System.out.println("치킨집"); for (Position chicken : chickens) {
		 * System.out.println(chicken.r + " " + chicken.c); }
		 */
		
		selectChicken(0, 0, new Stack<Position>());
		
		System.out.println(cityDist);

	}
	
	static void selectChicken(int start, int selectedNum, Stack<Position> selectedChickens) {
		
		if(selectedNum == M ) {
			
			int dist = calculateDist(selectedChickens);
			
			//System.out.println("dist " + dist);
			return ;
		}
		
		for(int i=start; i < chickens.size(); i++) {
			selectedChickens.push(chickens.get(i));
			selectChicken(i+1, selectedNum + 1, selectedChickens);
			selectedChickens.pop();
		}
		return ;
	}
	
	static int calculateDist(Stack<Position> selectedChickens) {
		//System.out.println("calculateDist");
		int tempCityDist = 0;
		int houseDist = Integer.MAX_VALUE;
		
		for (Position house: houses) {
			for (Position chicken : selectedChickens) {
				int cur = Math.abs(house.r - chicken.r) + Math.abs(house.c - chicken.c);
				
				if(houseDist > cur) {
					houseDist = cur;
				}
			}
			//System.out.println("houseDist " + houseDist);
			tempCityDist += houseDist;
			houseDist = Integer.MAX_VALUE;
		}
		
		if(tempCityDist < cityDist) {
			cityDist = tempCityDist;
		}
		return tempCityDist;
	}

}

class Position {
	int r, c;
	
	Position(int r, int c){
		this.r = r;
		this.c = c;
	}
}
