package solveTypeMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p4948 {
	
	public static int countPrime(int n) {
		
		int result = 0;
		for(int i=n+1;i<=n*2;i++) {
			if(isPrime(i)) {
				result++;
			}
		}
		return result;
		
	}
	
	public static boolean isPrime(int n) {
		if(n < 2 ) return false;
		if(n == 2) return true;
		if(n %2 == 0) return false;
		for(int i=3;i*i <= n;i+=2) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
		
	}
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true) {
			
			int n = Integer.parseInt(bf.readLine());
			
			if(n == 0) break;
			
			System.out.println(countPrime(n));
			
			
		}
	}
}
