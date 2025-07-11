package solveTypeBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//이항계수 1
public class p11050 {
	
	public static int factorial(int n) {
		
		int result = 1;
		if(n==1) return result;
		
		for(int i=2;i<=n;i++) {
			result *=i;
		}
		
		return result;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String lineString = br.readLine();
		StringTokenizer st = new StringTokenizer(lineString);
		
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int result = factorial(n) / (factorial(k) * factorial(n-k));
		System.out.println(result);
		
	}
}
