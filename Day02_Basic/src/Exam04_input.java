import java.util.Scanner;

public class Exam04_input {

	public static void main(String[] args) throws Exception {
			
		Scanner sc  = new Scanner(System.in);
		
		System.out.println("당신의 이름을 입력하세요.");
		String name = sc.nextLine();
		System.out.println(name+"님 안녕하세요. 당신의 연락처를 알려주세요.");
		String phone = sc.nextLine();
		System.out.println(name+"님 자리가 생기면 "+phone+" 번호로 연락드리겠습니다!");
		
		
	}

}
