import java.util.Scanner;

public class Quiz05 {
	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);
		
		System.out.println("노래 제목을 입력하세요");
		String songName = sc.nextLine();
		System.out.println("가수를 입력하세요");
		String singer = sc.nextLine();
		System.out.println("당신이 입력한 노래는 ["+songName+"] 이며, 가수 [" + singer+"]씨가 부른 노래입니다.");
	}
}
