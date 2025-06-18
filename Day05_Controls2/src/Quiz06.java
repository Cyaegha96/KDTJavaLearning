import java.util.Scanner;

public class Quiz06 {
	// Up & Down Game 코드
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int shortestScore = 101; //최단기록 설정용

		while (true) {

			System.out.println("== Up & Down Game ==");
			System.out.println();
			System.out.println("1. Game Start");
			System.out.println("2. Game score");
			System.out.println("3. End Game");
			System.out.println();
			System.out.print(">");
			int select = Integer.parseInt(sc.nextLine()); //메뉴 셀렉트
			if (select == 1) {
				System.out.println("<< Game start! >>");
				// UP&Down game 1~99까지의 숫자만
				int level = 0; //레벨 설정용
				int answer = (int) (Math.random() * 99 + 1); //정답은 난이도에 상관없이 미리 설정
				int newScore = 0; //게임 시작 시 기록 초기화

				System.out.print("Input Level : ");
				level = Integer.parseInt(sc.nextLine());
				if (level == 1) {// 레벨1 나혼자!
					
					while (true) {
						newScore++;
						System.out.print("Input Number : ");
						int player = Integer.parseInt(sc.nextLine());
						if (player < answer) {
							System.out.println("<<  U P  >>");
						} else if (player > answer) {
							System.out.println("<<  D O W N  >>");
						} else {
							System.out.println("<<  정 답  >>");
							System.out.println(newScore + "번만에 클리어했습니다.");
							if (shortestScore > newScore) {
								shortestScore = newScore;
							}
							break;
						}
					}
				} else if (level == 2) {// 레벨2 ai (멍충이)랑 배틀!
					
					while (true) {
						newScore++;
						System.out.print("Input Number : ");
						int player = Integer.parseInt(sc.nextLine());
						if (player < answer) {
							System.out.println("<<  U P  >>");
						} else if (player > answer) {
							System.out.println("<<  D O W N  >>");
						} else {
							System.out.println("<<  정 답  >>");
							System.out.println(newScore + "번만에 클리어했습니다.");
							if (shortestScore > newScore) {
								shortestScore = newScore;
							}
							break;
						}
						int cpu1 = (int) (Math.random() * 99 + 1); //ai cpu의 턴...!
						System.out.println("cpu : 정답은 " + cpu1 + "인것이 분명합니다...!");
						if (cpu1 < answer) {
							System.out.println("<<  U P  >>");
						} else if (cpu1 > answer) {
							System.out.println("<<  D O W N  >>");
						} else {
							System.out.println("<<  CPU 정 답  >>");
							System.out.println("<<  멍충한 인간 노력하세요  >>");
							System.out.println("<<  GAME LOSE  >>");
							break;
						}
					}
					
				} else if (level == 3) {// 레벨3 ai (똑똑이)랑 배틀!
					newScore = 0;
					int cpuHighNum = 99;
					int cpuLowNum = 1;
					while (true) {

						newScore++;
						System.out.print("Input Number : ");
						int player = Integer.parseInt(sc.nextLine());
						if (player < answer) {
							System.out.println("<<  U P  >>");
							if (cpuLowNum < player) {
								cpuLowNum = player+1;
							}
						} else if (player > answer) { // 플레이어가 정답보다 높은 수를 냈다면
							System.out.println("<<  D O W N  >>"); // 정답은 더 낮은 수입니다.
							if (cpuHighNum > player) { // Cpu가 가진 최대범위가 플레이어가 제시한거보다 높다면
								cpuHighNum = player-1;
							}
						} else {
							System.out.println("<<  정 답  >>");
							System.out.println(newScore + "번만에 클리어했습니다.");
							if (shortestScore > newScore) {
								shortestScore = newScore;
							}
							break;
						}
						System.out.println("현재 CPU의 범위: " + cpuLowNum + "~" + cpuHighNum+"\n"); //ai cpu의 턴...!

						int cpu1 = (int) (Math.random() * (cpuHighNum - cpuLowNum ) + cpuLowNum);
						System.out.println("cpu : 정답은 " + cpu1 + "인것이 분명합니다...!");

						if (cpu1 < answer) {
							System.out.println("<<  U P  >>");
							if (cpuLowNum < cpu1) {
								cpuLowNum = cpu1+1;
							}

						} else if (cpu1 > answer) {
							System.out.println("<<  D O W N  >>");
							if (cpuHighNum > cpu1) { // Cpu가 가진 최대범위가 플레이어가 제시한거보다 높다면
								cpuHighNum = cpu1-1;
							}
						} else {
							System.out.println("<<  CPU 정 답  >>");
							System.out.println("<<  멍충한 인간 노력하세요!!  >>");
							System.out.println("<<  GAME LOSE  >>\n");
							break;
						}
						System.out.println("현재 CPU의 범위: " + cpuLowNum + "~" + cpuHighNum+"\n");
					}
					
				} else {
					System.out.println("제대로 된 레벨을 입력해주세요");
				}
			} else if (select == 2) {
				// score 보드 지금까지 최단기록으로 플레이한 경우는 N번입니다.
				if (shortestScore == 101) {
					System.out.println("아직 게임 플레이 기록이 없거나 컴퓨터를 이기지 못했습니다.");

				} else {
					System.out.println("지금까지 최단기록으로 플레이한 경우는 " + shortestScore + "번입니다.");
				}
			} else if (select == 3) {
				System.out.println("게임을 종료합니다.");
				System.exit(0);
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
}
