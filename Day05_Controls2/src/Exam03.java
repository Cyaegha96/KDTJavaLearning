import java.util.Scanner;

public class Exam03 {

	public static void main(String[] args) {
		
		//숫자 데이터에 대해서는 비교식에 ==를, 문자열 데이터에 대해서는 비교식에 .equals를 사용한다
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("단어를 입력하세요: ");
		String word = scanner.nextLine();
		
//		if(word == "Apple") {
//			System.out.println("사과 입니다.");
//		}else {
//			System.out.println("사전에 없습니다.");
//		}
		if (word.equals("Apple")) {
			System.out.println("사과 입니다.");
		}else {
			System.out.println("사전에 없습니다.");
		}
		
	}

}
