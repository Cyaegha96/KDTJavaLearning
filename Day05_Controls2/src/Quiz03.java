import java.util.Scanner;

public class Quiz03 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		int choiceCoin =0;
		while(true) {
			System.out.println("===동전 앞 뒤 맞추기===");
			
			int rand = (int)(Math.random()*2)+1; 
			
			System.out.print("숫자를 입력해주세요 (1.앞면/2.뒷면) :");
			choiceCoin = Integer.parseInt(scanner.nextLine());
			if(choiceCoin!=1 && choiceCoin !=2) {
				System.out.println("올바른 입력 바랍니다.");
				continue;
			}
			System.out.println();
			if(choiceCoin == rand) {
				
				System.out.println("맞췄습니다^^ ");
			}else {
				System.out.println("땡! 틀렸습니다!");
			}
			System.out.println();
			System.out.println("---------------->restart");
			
		}
		

	}

}
