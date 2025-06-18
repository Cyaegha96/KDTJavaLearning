import java.util.Scanner;

public class Quiz06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Hello를 출력할 횟수 입력 : ");
		int num  = Integer.parseInt(sc.nextLine());
		int i = 1;
		while(i<=num) {
			System.out.println(i+ ": Hello");
			i++;
		}
	}
	
}
