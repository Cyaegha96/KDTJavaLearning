import java.util.Scanner;

public class Quiz04 {

	public static void main(String[] args) {
		// 가위바위보 중 하나를 선택, 승패를 결정하는 게임
		// 승패를 결정하는 if문은 중첩 if문 금지 (|| , && 연산자를 적절히 활용)
		Scanner scanner = new Scanner(System.in);
		String rspString = "";

		while (true) {
			System.out.println();
			System.out.println("===가위 바위 보 게임 ===");
			System.out.print("숫자를 선택하세요 (1.가위/2.바위/ 3.보) :");
			int player = Integer.parseInt(scanner.nextLine());
			int rand = (int) (Math.random() * 3) + 1;

			if (player != 1 && player != 2 && player != 3) {
				System.out.println("올바른 입력 바랍니다.");
				continue;
			}
			// 1 가위 2 바위 3 보
			switch (player) {
			case 1:
				rspString = "가위";
				break;
			case 2:
				rspString = "바위";
				break;
			case 3:
				rspString = "보";
				break;
			}
			System.out.println("======결과======");
			System.out.println("당신은 " + rspString + "를 냈습니다.");

			switch (rand) {
			case 1:
				rspString = "가위";
				break;
			case 2:
				rspString = "바위";
				break;
			case 3:
				rspString = "보";
				break;
			}
			System.out.println("컴퓨터는 " + rspString + "를 냈습니다.");
			System.out.println("==============");

			// (2.바위 > 1.가위) +(3.보 > 2.가위) + (3.보 >1.가위)
			if ((player == rand + 1) || (player == rand - 2)) {
				// 이겼을 때
				System.out.println("플레이어가 이겼습니다.");

			} else if (player == rand) {
				// 비겼을 때
				System.out.println("비겼습니다! 다시 한번!");
			} else {
				// 졌을 때
				System.out.println("플레이어가 졌습니다.ㅜㅜ");
			}
		}

	}
}
