package solveTypeTimeComplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//알고리즘 수업 - 알고리즘의 수행 시간 6
public class p24267 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(bf.readLine());
	
		System.out.println((n-1)*(n-2)*(n)/6);
		System.out.println(3);
	}
}
