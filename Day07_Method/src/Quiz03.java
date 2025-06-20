import java.util.Scanner;

public class Quiz03 {
	///계산기 프로그램의 일부 기능을 함수로 바꿔보기
	public static int validNum(String s) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(s);
		
		while(true) {
			try {
				return Integer.parseInt(scanner.nextLine());
				
			} catch (Exception e) {
				System.out.println("숫자를 입력해주세요.");
			}
		}
		
	}
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputString = null;
		
		
		while(true) {
			
			System.out.println("===계산기 프로그램===");
			System.out.println();
			System.out.print("연산자 입력 (+, -, *, /)");
			inputString = scanner.nextLine();
			
			if(inputString == "q") {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				
			}else if(!inputString.equals("+") && !inputString.equals("-")&&
					!inputString.equals("*") && !inputString.equals("/")){
				System.out.println("잘못된 연산자를 입력했습니다.");
				continue; //while문 처음으로 돌아감
				
			}
			
			int num1=validNum("첫번째 숫자 입력");
			int num2=validNum("두번째 숫자 입력");
			

			System.out.println("====결과====");
			System.out.println();
			
			switch (inputString){
			
			case "+": 
				System.out.println(num1 + " + " + num2 + " = "+(num1 + num2));
				break;
				
			case "-": 
				System.out.println(num1 + " - " + num2 + " = "+(num1 - num2));
				break;
				
			case "*":
				System.out.println(num1 + " * " + num2 + " = "+(num1 * num2));
				break;
				
			case "/":
				System.out.println(num1 + " / " + num2 + " = "+(num1 /(double) num2));
				break;
				
			default:
				
			}
			System.out.println();
		}

	}

}
