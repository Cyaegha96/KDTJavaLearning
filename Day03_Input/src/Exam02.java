import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("당신이 좋아하는 과일을 선택하세요");
		System.out.println("1. 사과 2. 딸기 3. 수박");
		int select = Integer.parseInt(sc.nextLine());

		if (select == 1) {
			System.out.println("사과는 영어로 Apple입니다");
		} else if (select == 2) {
			System.out.println("딸기는 영어로..Strawberry입니다");
		} else if (select == 3) {
			
			System.out.println("수박은 영어로..Watermelon 입니다");
		} else {
			System.out.println("메뉴를 다시 확인해주세요");
		}
	}

}
