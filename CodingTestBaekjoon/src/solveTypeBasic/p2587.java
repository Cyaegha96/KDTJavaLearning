package solveTypeBasic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//p2587 ´ëÇ¥°ª2
public class p2587 {
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for(int i=0;i<5;i++) {
			list.add(Integer.parseInt(sc.nextLine()));
			sum +=list.get(i);
		}
		Collections.sort(list);
		System.out.println(sum/5);
		
		System.out.println(list.get(2));
		
	}
}
