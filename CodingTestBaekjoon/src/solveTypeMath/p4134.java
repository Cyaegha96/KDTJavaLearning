package solveTypeMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//다음 소수
public class p4134 {
	
	public static long findNextPrime(long n) {
		while(!isPrime(n)) {
			n++;
		}
		return n;
	}
	
	public static boolean isPrime(long n) {
		if(n < 2) return false;
		if (n == 2) return true;
		if(n % 2 == 0) return false;
		for(long i = 3l; i * i <=n; i+=2) {
			if(n % i == 0) {
				return false;
			}
			
		}
		return true;
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		long[] arr = new long[n];
		for(int i=0;i<n;i++) {
			arr[i]= Long.parseLong(bf.readLine());
			
		}
		
		for(int i=0;i<n;i++) {
			System.out.println(findNextPrime(arr[i]));
		}
		
		
	}
}
