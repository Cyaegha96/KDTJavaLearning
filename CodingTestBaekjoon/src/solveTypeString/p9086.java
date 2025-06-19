package solveTypeString;
import java.util.Scanner;

public class p9086 {
			//¹®ÀÚ¿­
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 int testCase = Integer.parseInt(scanner.nextLine());
		 for (int i = 0; i < testCase; i++) {
			String testString =scanner.nextLine();
			System.out.println(testString.charAt(0)+""+testString.charAt(testString.length()-1) );
		}
		 
		 
	}

}
