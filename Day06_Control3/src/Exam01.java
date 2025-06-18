import java.util.Scanner;

public class Exam01 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int num = 0;
//숫자를 제대로 입력할 때 까지 무한정 입력 받고,
//제대로 입력하면 입력된 숫자가 몇인지 출력하는 프로그램
		while(true) {
			System.out.println("숫자를 입력하세요:");
			try {
				num= Integer.parseInt(scanner.nextLine());
				System.out.println("입력한 숫자는 : "+num);
				break;
			} catch (Exception e) {
				System.out.println("제대로 된 숫자를 입력할 때까지 도루마무");
			}
		}
		System.out.println("입력된 숫자는 " +num+"입니다");
		System.out.println("프로그램 종료");
	}
}
