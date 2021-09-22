package code9_23;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class 좌표정렬하기 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//1 <= N <= 100,000 점의 개수
		int N = input.nextInt();
		
		ArrayList<Point> arr = new ArrayList<Point>();
		
		for(int i = 0; i < N; i++) {
			int x = input.nextInt();
			int y = input.nextInt();
			arr.add(new Point(x,y));
		}
		Collections.sort(arr, new Comparator<Point>(){
			@Override
			public int compare(Point s1, Point s2) {
				if(s1.x < s2.x)
					return -1;
				else if(s1.x == s2.x) {
					if(s1.y <= s2.y) {
						return -1;
					}
				}
				return 1;
			}
		});
		
		for(Point s : arr) {
			System.out.println(s.x + " " + s.y);
		}
		
		

	}

}
