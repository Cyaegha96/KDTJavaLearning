import java.util.Scanner;

public class LotterySimulator {
	//복권 시뮬레이터
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int[] lottery = new int[45];
		int[] myLottery = new int[45];
		int[] winCount = new int[6];
		String[] lottoPrize = {"꽝", "5등", "4등","3등","2등","1등"};

		for(int i=0;i<45;i++) {
			lottery[i] = i+1;
		}
		long week= 1;
		

		while(true) {

	
			//이번 주차는...!

			System.out.print(week +" 주차 의 로또 번호 는 : ");
			//이번 주차의 당첨 번호 섞기!
			for(int i=0;i<456;i++) {
				int a = (int)(Math.random()*45);
				int b = (int)(Math.random()*45);

				int temp = lottery[a];
				lottery[a] = lottery[b];
				lottery[b] = temp;
			}

			//이번 주차 당첨 번호는...!
			for(int i=0;i<6;i++) {
				System.out.print("("+lottery[i] + ") ");
			}
			System.out.print("|| 보너스 번호는 " + lottery[6] + " || ");

			//내가 산 번호...!
			for(int i=0;i<45;i++) {
				myLottery[i] = i+1;
			}

			//꿈에서 할아버지가 이거 사랬어!!
			for(int i=0;i<456;i++) {
				int a = (int)(Math.random()*45);
				int b = (int)(Math.random()*45);

				int temp = myLottery[a];
				myLottery[a] = myLottery[b];
				myLottery[b] = temp;
			}

			//내가 산 번호는...!
			System.out.print("내가 고른 숫자 6개: ");
			for(int i=0;i<6;i++) {
				System.out.print(lottery[i] + " ");
			}

			System.out.print("|| ");
	
			//로또 번호 맞는지 확인
			int lotteryCount = 0;
			int bonusCheck = 0;

			for(int i=0;i<6;i++) {
				for(int j=0;j<6;j++) {
					if(myLottery[i] == lottery[j]) {
						lotteryCount++;
					}
				}
				if(myLottery[i] == lottery[6]) {
					bonusCheck++;
				}
			}


			if(lotteryCount == 6) {
				//완벽하게 숫자 6개 일치 1등!!
				System.out.println();
				System.out.println("=============");
				System.out.println("1등 축하드립니다!!!! 끼야아앗호우우!!");
				System.out.println("당첨금 50억원!!! 원금 회수... 하셨습니까?");
				winCount[5]++;
	

				System.out.println("로또 1등이 나오기 까지 시행착오 및 당첨 횟수===");
				for(int i=0;i<6;i++) {

					System.out.println(lottoPrize[i]+"이 나온 횟수 :"+winCount[i]);
					System.out.println(lottoPrize[i]+"이 나올 확률 :"+( (double) winCount[i] / (double) week) );
				}
				System.exit(0);
			}
			else if(lotteryCount==5 && bonusCheck ==1) {
				System.out.println("2등ㅜㅜ 좀 모자랐으...당첨금 5천만원");
				winCount[4]++;

			}
			else if(lotteryCount == 5) {
				System.out.println("3등ㅜㅜ 그나마 나은가? 당첨금 100만원");
				winCount[3]++;


			}else if(lotteryCount == 4) {
				System.out.println("일치하는 숫자 4개 ... 4등ㅜㅜ 당첨금 5만원 ");
				winCount[2]++;
		
			}else if(lotteryCount == 3) {
				System.out.println("일치 하는 숫자 3개... 5등ㅜㅜ 당첨금 5천원");
				winCount[1]++;
		
			}else {
				System.out.println("일치하는 숫자 없음... 완전 꽝 ㅜㅜ ");
				winCount[0]++;
			}
			

			
			week++;
		}


	}
}
