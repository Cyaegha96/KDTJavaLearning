import java.sql.ResultSet;
import java.util.Scanner;

public class Exam02 {
	public static void main(String[] args) {
		//switch
		Scanner scanner = new Scanner(System.in);
		System.out.println("1,2,3 중에 입력");
		int input = Integer.parseInt(scanner.nextLine());
		
		String result = switch(input) {
		 	case 1 ->"1을 입력했습니다.";
		 	case 2 ->"2를 입력했습니다.";
		 	case 3 ->"3을 입력했습니다.";
		 	default ->"이상한 숫자";
		};
		System.out.println(result);
	}
}
