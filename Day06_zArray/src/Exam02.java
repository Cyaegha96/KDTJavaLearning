import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] num = new int[3];
		
		for(int i =0;i<3;i++) {
			
			while(true) {
				try {
					System.out.print((i+1)+"번째 수:");
					num[i] = Integer.parseInt(sc.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("숫자 제대로 입력바람");
				}
			}
		}
		for(int i=0;i<3;i++) {
			if(num.length-1 == i) {
				System.out.print(num[i]);
			}
			else {
				System.out.print(num[i] + ", ");
			}
		}

	}

}
