import java.util.Scanner;

public class Exam01 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요 : ");
		String num = sc.nextLine();
		int realNumber = Integer.parseInt(num);
		System.out.println("입력한 숫자와 10을 더한 결과는 " +(realNumber+ 10));
	}
}
