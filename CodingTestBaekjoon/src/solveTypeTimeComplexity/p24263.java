package solveTypeTimeComplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//알고리즘 수업 - 알고리즘의 수행 시간 2
public class p24263 {
	static int count=0;
	static int TimeComplex =0;
	public static void menOfPassion(int n) {
		TimeComplex++;
		for(int i=0;i<n;i++) {
			count++;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		menOfPassion(n);
		System.out.println(count);
		System.out.println(TimeComplex);
	}
}
