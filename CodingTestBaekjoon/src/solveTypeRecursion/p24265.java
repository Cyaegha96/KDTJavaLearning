package solveTypeRecursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//�˰��� ���� - �˰����� ���� �ð� 4
public class p24265 {
	

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(bf.readLine());
	
		System.out.println(n * (n-1)/2);
		System.out.println(2);
	}
}
