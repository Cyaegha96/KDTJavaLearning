package solveTypeMath;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//골든바흐 파티션
public class p17103 {
	
	public static boolean isPrime(int n ) {
		if(n <2) return false;
		if(n==2) return true;
		if(n%2 ==0 ) return false;
		for(int i=3; i * i <= n; i+=2) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(bf.readLine());
		int[] arr = new int[n];
		
		
		int maxNum = 0;
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(bf.readLine());
			maxNum = Math.max(maxNum,  arr[i]);
		}
		boolean[] prime = new boolean[maxNum+1];
		//소수 미리 넣어두기
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		for(int i=2;i * i <=maxNum;i++) {
			if(prime[i]) {
				for(int j = i*i;j<=maxNum;j+=i) {
					prime[j] = false;
				}
			}
		}
		
		
		for(int i=0;i<n;i++) {
			int target= arr[i];

			int result = 0;
			for(int j=2;j<=arr[i]/2;j++) {
				if( prime[j] && prime[target-j]) {
					result++;
				}
			}
			bw.write(result+"\n");
			
		}
		bw.flush();
		
		
	}
}
