
import java.util.Scanner;

public class Quiz01 {
	public static void main(String[] args) {
		//경마게임
		Scanner sc = new Scanner(System.in);
		int gamblePercent = 50;
		int destroyerPercent = 1;
		long amount = 10000;
		int hourseCount = 3;
		boolean normalLife = true;
		boolean gambleLife = false;
		System.out.println(">>>경마 게임에 오신걸 환영합니다.<<<");
		
		while(true) {
			
			System.out.println("1. 게임 시작");
			if(normalLife) {
				System.out.println("2. 잔액 충전");
			}
			System.out.println("3. 잔액 조회");
			System.out.println("4. 게임 종료");
			if(gambleLife) {
				System.out.println("5. 소액 대출");
			}
			System.out.print("번호를 선택하세요 : ");
			int select = Integer.parseInt(sc.nextLine());
			
			if(select == 1) {//게임 시작
				if(amount <=0) {
					System.out.println("현재 잔액은 "+amount +"원입니다.");
					System.out.println("이 금액으로는 배팅을 진행할 수 없습니다.");
					continue;
				}
				
				System.out.println("말들이 준비 되었습니다. 배팅하고 싶은 말을 선택해주세요.");
				System.out.println("1번 말: 아무튼 개잘달림. 왠지 이길거 같음");
				System.out.println("2번 말: 비실비실함. 그래도 눈이 총명함. 왠지 이길거 같음");
				System.out.println("3번 말: 막 다리 절고 그러는게 힙합 잘할거 같음. 왠지 이길거 같음");
				if(!normalLife) {
					hourseCount = 5;
					System.out.println("(어라...? 말이 늘었어?)");
					System.out.println("4번 말: 적토마. 관우가 애용하던 말. 나이가 너무 많지만 왠지 이길거 같음.");
					System.out.println("5번 말: 말이 아님. 옆에서 대출 받던 사람이 서있음. 솔직히 이길것 같진 않음.");
				}
				
				System.out.println("말의 등 번호를 입력하세요:");
				
				int playerGamble = Integer.parseInt(sc.nextLine());
				if(!(0 < playerGamble && playerGamble < hourseCount +1)) {
					System.out.println("그런말은 존재하지 않습니다.");
					System.out.println("당신은 경마장 밖으로 쫓겨났습니다.");
					continue;
				}
				System.out.println(playerGamble+"번 말을 고르셨습니다.");
				
				System.out.println("선택한 말이 우승할 경우 베팅액의 "+gamblePercent+"퍼센트를 받게 됩니다.");
				System.out.println("현재 잔액은 "+amount +"원입니다.");
				System.out.print("베팅할 금액을 입력해주세요(최소금액: 1000원):");
				long playerBetting = Long.parseLong(sc.nextLine());
				if(playerBetting < 1000) {
					System.out.println("베팅할 금액이 충분하지 않습니다.");
					System.out.println("혹시 소액대출이 필요하신가요? 5번 메뉴를 활용해주세요.");
					gambleLife  = true;
					continue;
				}else if (playerBetting > amount) {
					System.out.println("베팅할 금액이 충분하지 않습니다.");
					System.out.println("혹시 소액대출이 필요하신가요? 5번 메뉴를 활용해주세요.");
					gambleLife  = true;
					continue;
				}
				int answer = (int) (Math.random() * hourseCount + 1); 
				
				System.out.println("\n<<경기가 시작됩니다.>>");
				for (int i = 0; i < 3; i++) { // 총 3번 반복
					System.out.println("말달리자 ~~ 두구두구...");
		            try {
		                Thread.sleep(300); // 300밀리초 동안 대기
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }
		        }

				if(playerGamble ==answer ) {
					System.out.println("\n축하합니다! "+answer+" 번 말이 우승했습니다.");
					System.out.println("배팅액을 벌었습니다!");
					amount = amount+ (long)  (playerBetting*0.5);
					System.out.println("현재 잔액은 "+amount +"원입니다.");
				}else {
					System.out.println("\n아쉽습니다."+answer+" 번 말이 우승했습니다.");
					System.out.println("배팅액을 잃었습니다.");
					if(gambleLife) {
						amount -= playerBetting*destroyerPercent;
					}else {
						amount -= playerBetting;
					}
					System.out.println("현재 잔액은 "+amount +"원입니다.");
					if(amount <=0) {
						System.out.println("혹시 소액대출이 필요하신가요? 5번 메뉴를 활용해주세요.");
						gambleLife  = true;
					}
				
				}
				
			}else if(select ==2) { //잔액 충전
				if(amount <0) {
					System.out.println("신용불량자는 금액을 충전할 수 없습니다.");
					System.out.println("다음 부터는 소액 대출 메뉴를 이용해주세요");
					normalLife = false;
				}else if(gambleLife){
					System.out.println("당신은 소액대출에 눈을 떴습니다....");
					System.out.println("평범한 삶으로는 이제 돌아갈 수 없습니다...");
					normalLife = false;
				}
				else{
					System.out.println("얼마를 충전하시겠습니까? 단위 : 원/ 최대 백만원");
					long inputMoney = Long.parseLong(sc.nextLine());
					if(inputMoney <=0) {
						System.out.println("마이너스 금액은 입력할 수 없습니다.");
						System.out.println("혹시 돈이 없으신가요? 소액 대출 메뉴를 이용하시기 바랍니다....");
						gambleLife  = true;
					}else if(inputMoney >1000000){
						System.out.println("착각하시는거 아닌가요? 당신의 통장에 그만큼의 돈은 없습니다.");
						System.out.println("혹시 돈이 없으신가요? 소액 대출 메뉴를 이용하시기 바랍니다....");
						gambleLife  = true;
					}
					else{
						amount += inputMoney;
						System.out.println("충전 후 잔액은 :"+amount+"원 입니다.");
					}
				}
				
			}else if(select==3) { //잔액 조회
				System.out.println("현재 잔액은 "+amount +"원입니다.");
				
			}else if(select==4){//게임 종료
				System.out.println("현생으로 탈출하신걸 축하드립니다.");
				System.exit(0);
				
			
			}else if(select == 5) {//소액 대출
				if(!gambleLife) {
					System.out.println("...? 어떻게 찾아오신진 모르겠지만, 이런 세계에는 발도 붙이지 않는게 좋습니다.");
					System.out.println("당신은 수상한 가게에서 발을 돌린다...");
					continue;
				}
				System.out.println("소액대출 메뉴에 오신걸 환영합니다.");
				System.out.println("여기서는 돈이 없어도 원하는만큼 금액을 입력받을 수 있습니다.");	
				System.out.println("대신 앞으로 패배시에는 배팅액을 두배로 잃게 되며,보유 금액이 마이너스로 차감될 수 있습니다.");	
				System.out.println("얼마를 충전하시겠습니까? 단위 : 백만원/최대 10억원까지 가능");
				normalLife = false;
				long inputMoney = Long.parseLong(sc.nextLine());
				
				if(inputMoney <=0) {
					System.out.println("여기 들어온 이상 낙장불입은 없습니다.");
					System.out.println("강제로 백만원이 입금됩니다.");
					amount += 1000000;
					System.out.println("현재 잔액은 "+amount +"원입니다.");
					destroyerPercent*=2;
					System.out.println("게임 졌을 때 금액 "+destroyerPercent+"배로 잃음");
				}else if(inputMoney >1000) {
					System.out.println("그렇게는 돈을 빌릴 수 없습니다....");
					System.out.println("욕심을 부린 댓가로 패배시 배율이 누적됩니다");
					destroyerPercent*=2;
					System.out.println("게임 졌을 때 금액 "+destroyerPercent+"배로 잃음");
				}else {
					amount += inputMoney *1000000;
					System.out.println("현재 잔액은 "+amount +"원입니다.");
					destroyerPercent*=2;
					System.out.println("게임 졌을 때 금액 "+destroyerPercent+"배로 잃음");
				}
			
			}
			else {
				System.out.println("제대로된 번호를 입력해주세요");
			}
		}
	}
}
