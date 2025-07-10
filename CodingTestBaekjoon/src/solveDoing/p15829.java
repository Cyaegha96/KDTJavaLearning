package solveDoing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Hashing
public class p15829 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf =  new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		long result =0;
		
		String lineString = bf.readLine();
		char[] arr = lineString.toCharArray();
		for(int i=0;i<N;i++) {
			char target = arr[i];
			result += (long) (target-96) * (long) Math.pow(31, i);
		}
		System.out.println(result);
		
	}
}
