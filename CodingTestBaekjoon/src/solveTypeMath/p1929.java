package solveTypeMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1929 {
	
	
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
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int m=Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		for(int i=m; i<=n;i++ ) {
			
			if(isPrime(i)) System.out.println(i);
		}
		
	}
}


