import java.util.Scanner;

public class gugudan {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("===구구단 출력 프로그램===");

		while(true) {
			System.out.print("1~9단 중 선택:");
			
			int num = Integer.parseInt(sc.nextLine());
			//사용자로부터 단 값을 입력받는 코드
			
			if(1<=num && num < 10) {
				int i =0;
				while(i <=9) {
					System.out.println( num + " * " + i + " = " + (num * i));
					i++;
				}
				//입력된 단값에 대한 1부터 9까지의 곱셈 결과를 출력하는 코드
			}else {
				System.out.println("범위를 벗어났습니다");
			}
		}
		
		
	}
}
