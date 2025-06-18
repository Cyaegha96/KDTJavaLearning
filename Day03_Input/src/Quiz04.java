import java.util.Scanner;

public class Quiz04 {
	public static void main(String[] args) {

		// 시험점수를 입력하세요 (0~100)

		Scanner sc = new Scanner(System.in);

		System.out.print("시험점수를 입력하세요 (0~100) : ");
		int score = Integer.parseInt(sc.nextLine());

		if (0 <= score && score <= 100) {
			if (score >= 90) {
				System.out.println("당신의 점수 등급은 A 입니다.");
			} else if (score >= 80) {
				System.out.println("당신의 점수 등급은 B 입니다.");
			} else if (score >= 70) {
				System.out.println("당신의 점수 등급은 C 입니다.");
			} else {
				System.out.println("당신의 점수 등급은 D 입니다.");
			}
		} else {
			System.out.println("점수가 입력 범위를 벗어났습니다.");
		}

	}
}
