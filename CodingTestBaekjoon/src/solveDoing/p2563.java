package solveDoing;
import java.util.Scanner;

public class p2563 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[][] arr = new int[100][100];
		int input = scanner.nextInt();

		
		for(int i=0;i<input;i++) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			
			for(int num1 = n; num1<n+10;num1++) {
				for(int num2 = m;num2<m+10;num2++) {
					arr[num1][num2]=1;
				}
			}
		}
		
		int count = 0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(arr[i][j] == 1) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
