import java.util.Scanner;

public class Quiz01 {

	public static void main(String[] args) {
		//두숫자를 입력받아 덧셈한 결과를 출력하는 프로그램을 작성
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 숫자를 입력해주세요:");
		int num1 =  Integer.parseInt(sc.nextLine());
		
		System.out.print("두번째 숫자를 입력해주세요:");
		int num2 =  Integer.parseInt(sc.nextLine());
		
		System.out.println("입력한 숫자의 합:" + (num1+num2));

	}

}
