import java.util.Scanner;

public class Quiz02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int amount = 3000;
		
		int check=0;
		
		while(true) {
			
			System.out.println("<<< ATM Simulator >>>");
			System.out.println("1. 잔액조회");
			System.out.println("2. 입금하기");
			System.out.println("3. 출금하기");
			System.out.println("4. 종료하기");
			
			
			while(true) {
				System.out.print(">>");
				try {
					check= Integer.parseInt(sc.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("번호를 제대로 입력해주세요");
				}
			}
			
			if(check == 1) {
				System.out.println("현재 잔액은 "+amount+"원 입니다.");
				
			}else if(check==2) {
				
				System.out.print("얼마를 입금하시겠습니까? ");
				while(true) {
		
					try {
						int addAmount= Integer.parseInt(sc.nextLine());
						amount+=addAmount; 
						break;
					} catch (Exception e) {
						System.out.println("입금 금액을 제대로 입력해주세요");
					}
				}
			
				System.out.println("현재 잔액은 "+amount+"원 입니다.");
			}else if(check==3) {
				System.out.print("얼마를 출금하시겠습니까? ");
				int minusAmount = 0;
				while(true) {
		
					try {
						minusAmount = Integer.parseInt(sc.nextLine());
						break;
					} catch (Exception e) {
						System.out.println("출금 금액을 제대로 입력해주세요");
					}
				}
				
				if(minusAmount > amount) {
					System.out.println("한도초과 금액입니다");
				}else {
					amount-=minusAmount;
				}
				System.out.println("현재 잔액은 "+amount+"원 입니다.");
			}
			else if(check==4) {
				System.out.println("시뮬레이터를 종료합니다.");
				break;
			}else {
				System.out.println("정확한 숫자를 입력해주세요");
			}
		}
		
	}

}
