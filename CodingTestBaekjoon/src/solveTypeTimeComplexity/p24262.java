package solveTypeTimeComplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//�˰��� ���� - �˰����� ���� �ð� 1
public class p24262 {
	static int count = 0;
	public static void menOfPassion(int n) {
		
		count++;
		return ;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		menOfPassion(n);
		System.out.println(count);
		System.out.println(0);
		
	}
}
