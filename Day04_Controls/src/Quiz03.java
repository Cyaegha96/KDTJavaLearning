import java.util.Scanner;

public class Quiz03 {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		//자판기 시뮬레이터
		int amount=3000; //소지금
		
		int drinkColaPrice =1000; //콜라 가격
		int drinkCiderPrice = 800; //사이다 가격
		int drinkTeaPrice = 1500; //매실차 가격
		int drinkColaCount = 0; //콜라 개수
		int drinkCiderCount = 0; //사이다 개수
		int drinkTeaCount = 0; //매실차 개수
		
		
		Scanner sc = new Scanner(System.in);

		int select = 0;
		while(true) {
			System.out.println("<< 자판기 시뮬레이터 >>");
			System.out.println("1. 콜라(1000) / 2. 사이다(800) / 3. 매실차(1500) / 0. 소지품 / 9.종료");
			System.out.print(">>");

			select = Integer.parseInt(sc.nextLine());
			
			if(select == 0) {
				System.out.println("=====소지품=====");
				System.out.println("소지금: "+amount +"원");
				System.out.println("콜라: " + drinkColaCount+"개");
				System.out.println("사이다: " + drinkCiderCount+"개");
				System.out.println("매실차: " + drinkTeaCount+"개");				
				System.out.println("================");
				
			}else if(select ==1) {
				if(amount>=drinkColaPrice) {
					System.out.println("콜라를 구매합니다.");
					System.out.println("소지금 -" +drinkColaPrice+ "원");
					amount -=drinkColaPrice;
					System.out.println("콜라 +1개");
					drinkColaCount++;
				}else {
					System.out.println("소지금이 부족합니다.");
				}

			}else if(select ==2) {
				if(amount>=drinkCiderPrice) {
					System.out.println("사이다를 구매합니다.");
					System.out.println("소지금 -" +drinkCiderPrice+ "원");
					amount -=drinkCiderPrice;
					System.out.println("사이다 +1개");
					drinkCiderCount++;
				}else {
					System.out.println("소지금이 부족합니다.");
				}

			}else if(select ==3) {
				if(amount>=drinkTeaPrice) {
					System.out.println("매실차를 구매합니다.");
					System.out.println("소지금 -" +drinkTeaPrice+ "원");
					amount -=drinkTeaPrice;
					System.out.println("매실차 +1개");
					drinkTeaCount++;
				}else {
					System.out.println("소지금이 부족합니다.");
				}

			}else if(select==9){
				System.out.println("자판기를 종료합니다.");
				//break;
				System.exit(0); //현재 실행중인 프로그램 즉시 종료
			}else {
				System.out.println("제대로 된 명령어를 입력해주세요.");
			}
		}

	}

}
