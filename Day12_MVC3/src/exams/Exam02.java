package exams;


public class Exam02 {
	public static void main(String[] args) {
		
		String[] arr= new String[10];
		arr[0] = "Hello";
		arr[1] = "Java";
		arr[2] = "Collection";
		

		
//		//0번 요소 삭제
//		arr[0] = arr[1];
//		arr[1] = arr[2];
//		arr[2] = null;
		
		arr[3] = arr[2];
		arr[2] = "World";
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		
	
		
	}
}
