import java.util.Scanner;

public class Quiz05 {
	//Up & Down Game 코드
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int shortestScore = 101;
		
		while(true) {
			
			System.out.println("== Up & Down Game ==");
			System.out.println();
			System.out.println("1. Game Start");
			System.out.println("2. Game score");
			System.out.println("3. End Game");
			System.out.println();
			System.out.print(">");
			int select = Integer.parseInt(sc.nextLine());
			switch (select) {
			case 1: 
				System.out.println("<< Game start! >>");
				//UP&Down game 1~99까지의 숫자만
				int answer = (int) (Math.random()*99+1);
				int newScore = 0;
				while(true) {
					newScore++;
					System.out.print("Input Number : ");
					int player = Integer.parseInt(sc.nextLine());
					if(player <answer) {
						System.out.println("<<  U P  >>");
					}else if(player > answer) {						
						System.out.println("<<  D O W N  >>");
					}else {
						System.out.println("<<  정 답  >>");
						System.out.println(newScore+"번만에 클리어했습니다.");
						if(shortestScore < newScore) {
							shortestScore = newScore;
						}
						break;
					}					
				}				
				break;
			case 2:
				//score 보드 지금까지 최단기록으로 플레이한 경우는 N번입니다.
				if(shortestScore == 101) {
					System.out.println("아직 게임 플레이 기록이 없습니다.");
					
				}else {
					System.out.println("지금까지 최단기록으로 플레이한 경우는 "+shortestScore+"번입니다.");
				}
				break;
			case 3:
				System.out.println("게임을 종료합니다.");
				System.exit(0);
			default:
				System.out.println("잘못된 입력입니다.");
				
			}
		}
	}
}
