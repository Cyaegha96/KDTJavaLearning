import java.util.Scanner;

public class Quiz02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("===================");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.println("===================");
		System.out.println("국어 : " );
		int korean = Integer.parseInt(sc.nextLine());
		System.out.print("영어 : ");
		int eng = Integer.parseInt(sc.nextLine());
		System.out.print("수학 : ");
		int math = Integer.parseInt(sc.nextLine());
		System.out.println("===================");
		System.out.println("합계 : " + (korean + eng + math));
		System.out.printf("평균 : %.2f%n", (korean + eng + math) / 3.0);
		System.out.println("===================");
	}
}
