import java.util.Scanner;

public class Exam03 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String[] name = new String[3];
		int[] korean = new int[3];
		int[] english = new int[3];
		for (int i = 0; i <3; i++) {
			System.out.print((i+1)+" 번째 학생 이름: ");
			name[i] = scanner.nextLine();
			System.out.print(name[i]+" 학생 국어: ");
			korean[i] = Integer.parseInt(scanner.nextLine());
			System.out.print(name[i]+" 학생 영어: ");
			english[i] = Integer.parseInt(scanner.nextLine());
		}
		System.out.println("이름\t국어\t영어\t합계\t평균\t");
		for (int i = 0; i <3; i++) {
			int sum = (korean[i]+english[i]);
			float avg = sum / 2.0f;
			System.out.println(name[i]+"\t"+korean[i]+"\t"+english[i]+"\t"+sum+"\t"+avg+"\t");
		}
		
	}
}
