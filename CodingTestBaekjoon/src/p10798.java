
import java.io.IOException;
import java.util.Scanner;


public class p10798 {
	//세로읽기
	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(System.in);

		String answer = "";
		String temp = scanner.nextLine();
		int max = temp.length();
		
		char[][] arr = new char[15][15];	
		for(int j=0;j<max;j++) {
			arr[0][j] = temp.charAt(j);
		}
		
		
		for(int i=1;i<5;i++) {
			temp = scanner.nextLine();
			if(max < temp.length()) max = temp.length();
			for(int j=0;j<temp.length();j++) {
				arr[i][j] = temp.charAt(j);
			}
		}
		
		for(int i=0;i<max;i++) {
			for(int j=0;j<5;j++) {	
				answer += arr[j][i];		
			}
		}
		System.out.println(answer.replace("\0",""));

	}

}
