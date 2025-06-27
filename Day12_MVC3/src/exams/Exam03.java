package exams;

import java.util.ArrayList;

public class Exam03 {
	public static void main(String[] args) {
		
		ArrayList arr = new ArrayList();
		arr.add("Hello");
		arr.add("Java");
		arr.add("Collection");
		arr.add(10);
		arr.add(3.14);

		
		
		System.out.println(arr.size());
		
//		//0번 요소 삭제
//		
//		arr.remove(0);
		
		arr.add(2,"World");
		
		
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		System.out.println(arr.get(2));
		System.out.println(arr.get(3));

	}
}
