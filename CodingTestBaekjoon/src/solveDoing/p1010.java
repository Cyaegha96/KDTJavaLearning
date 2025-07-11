package solveDoing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//다리놓기
public class p1010 {
	
	static long[][] dp = new long[30][30];
	
	public static long bridge(int n, int m) {
		
		if(n<=0 || m<=0) {
			return 0;
		}
		
		if(dp[n][m] != 0) {
			return dp[n][m];
		}
		
		
		//다리가 한쪽이라도 0이면 방법은 0
		if(n +m <=1) {
			return dp[n][m] = 0;
		}
		if(n == 1 && m == 1) {
			return dp[n][m] = 1;
		}
		
		if(dp[n-1][m-1] !=0 ) {
			return dp[n][m] = dp[n-1][m-1];
		}
		
		
		return dp[n][m] = bridge(n-1, m)+1;
	}
	
		
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		///dp
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T  = Integer.parseInt(br.readLine());
		
		
		for(int i=0;i< T;i++) {
			String line = br.readLine();
			st = new StringTokenizer(line);
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			
			System.out.println(bridge(n, m));
	
		}
		
		
	}
}
